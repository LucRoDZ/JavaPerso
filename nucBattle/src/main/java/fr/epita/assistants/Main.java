package fr.epita.assistants;

import fr.epita.assistants.nucbattle.BattleManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/exampleBattle1.json";  // Set correct path

        try {
            BattleManager battleManager = new BattleManager(inputFilePath);
            battleManager.computeBattle("output.json");
            System.out.println("Battle computation completed. Check 'output.json' for results.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
