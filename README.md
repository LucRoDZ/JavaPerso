# JavaPerso
package fr.epita.assistants.war;

public class Soldier extends Combatant {
    protected int healthPoints;
    protected int damagePoints;
    protected String scream;

    public Soldier() {
        this.healthPoints = 15;
        this.damagePoints = 3;
        this.scream = "No pity for losers!";
    }

    public void kill() {
        this.healthPoints = 0;
    }

    @Override
    public void printState() {
        System.out.println("I have " + this.healthPoints + " health points.");
    }

    @Override
    public void attack(Soldier s) {
        s.healthPoints -= this.damagePoints;
    }

    @Override
    public void attack(Vehicle v) {
        System.out.println("I can't fight this.");
    }

    @Override
    public void scream() {
        System.out.println(this.scream);
    }
}
