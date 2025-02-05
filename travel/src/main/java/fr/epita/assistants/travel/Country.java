package fr.epita.assistants.travel;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class Country {
    public String countryName;
    public ZoneId countryZone;
    public Map<String, Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    private Map<String, Integer> initTravelTimes(String inputFilePath) {
        Map<String, Integer> travelTimes = new HashMap<>();

        if (Files.notExists(Paths.get(inputFilePath))) {
            System.out.println("Erreur : fichier CSV introuvable -> " + inputFilePath);
            return travelTimes;
        }

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length < 3 || "source".equalsIgnoreCase(record[0])) continue;

                String source = record[0].trim();
                String destination = record[1].trim();
                int time = Integer.parseInt(record[2].trim());

                if (source.equalsIgnoreCase(this.countryName)) {
                    travelTimes.put(destination, time);
                }
                if (destination.equalsIgnoreCase(this.countryName)) {
                    travelTimes.put(source, time);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return travelTimes;
    }
}
