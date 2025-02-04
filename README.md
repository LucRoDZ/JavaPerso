package fr.epita.assistants.war;

public class Vehicle extends Combatant {
    private String modelName;
    private int defensePoints;

    public Vehicle(String name, int defense) {
        this.modelName = name;
        this.defensePoints = defense;
    }

    @Override
    public void printState() {
        System.out.println("I have " + this.defensePoints + " defense points.");
    }

    @Override
    public void attack(Soldier s) {
        s.kill();
    }

    @Override
    public void attack(Vehicle v) {
        v.defensePoints /= 2;
    }

    @Override
    public void scream() {
        System.out.println("I'm " + this.modelName + "!");
    }
}
