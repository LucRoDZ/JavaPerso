package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Map;

public class TurnDeserializer extends JsonDeserializer<Turn> {
    private final Map<String, Nuc> nucs;

    public TurnDeserializer(Map<String, Nuc> nucs) {
        this.nucs = nucs;
    }

    @Override
    public Turn deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        String playerLogin = node.get("player_login").asText();
        String targetLogin = node.get("target_login").asText();

        JsonNode packetNode = node.get("packet");
        Packet packet = p.getCodec().treeToValue(packetNode, Packet.class);

        return new Turn(nucs.get(playerLogin), playerLogin, nucs.get(targetLogin), targetLogin, packet);
    }
}
