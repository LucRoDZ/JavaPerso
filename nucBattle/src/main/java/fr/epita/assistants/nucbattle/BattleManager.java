package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleManager {
    private final Battle battle;
    private final Map<String, Nuc> nucs;

    public BattleManager(String path) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Object> data = mapper.readValue(new File(path), Map.class);

            Map<String, Nuc> nucMap = new HashMap<>();
            Map<String, Map<String, Object>> nucsData = (Map<String, Map<String, Object>>) data.get("NUCs");
            for (Map.Entry<String, Map<String, Object>> entry : nucsData.entrySet()) {
                Nuc nuc = mapper.convertValue(entry.getValue(), Nuc.class);
                nucMap.put(entry.getKey(), nuc);
            }
            this.nucs = nucMap;

            ObjectMapper battleMapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Turn.class, new TurnDeserializer(nucMap));
            battleMapper.registerModule(module);

            this.battle = battleMapper.convertValue(data.get("battle"), Battle.class);
        } catch (JsonParseException | JsonMappingException e) {
            generateReport("output.json", ReportType.ERROR, null, null);
            throw new RuntimeException("JSON Syntax Error in file: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("File Read Error: " + path, e);
        }
    }

    public void computeBattle(String outputFilePath) {
        try {
            Map<String, Float> finalHp = new HashMap<>();
            for (String player : nucs.keySet()) {
                finalHp.put(player, nucs.get(player).getHp());
            }

            for (Turn turn : battle.getTurns()) {
                for (String program : turn.getPacket().getUsedPrograms()) {
                    if (!turn.getPlayerNuc().getInstalledPrograms().contains(program)) {
                        generateReport(outputFilePath, ReportType.CHEATER, turn.getPlayerLogin(), null);
                        return;
                    }
                }

                float newHp = finalHp.get(turn.getTargetLogin()) - turn.getPacket().getDamage();
                finalHp.put(turn.getTargetLogin(), Math.max(0, Math.min(100, newHp)));

                List<String> remainingPlayers = finalHp.entrySet().stream()
                        .filter(entry -> entry.getValue() > 0)
                        .map(Map.Entry::getKey)
                        .toList();

                if (remainingPlayers.size() == 1) {
                    generateReport(outputFilePath, ReportType.WINNER, remainingPlayers.get(0), finalHp);
                    return;
                }
            }

            generateReport(outputFilePath, ReportType.UNFINISHED, null, finalHp);
        } catch (Exception e) {
            generateReport(outputFilePath, ReportType.ERROR, null, null);
        }
    }

    private void generateReport(String outputFilePath, ReportType type, String player, Map<String, Float> outcome) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Report report = new Report(type, player, outcome);
            mapper.writeValue(new File(outputFilePath), report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
