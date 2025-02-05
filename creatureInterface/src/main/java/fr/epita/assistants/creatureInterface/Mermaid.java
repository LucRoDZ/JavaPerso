package fr.epita.assistants.creatureInterface;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Mermaid extends BaseHuman implements MagicalInterface {
    private int mana;
    private boolean swimmingState;
    private Set<Spell> spells = new HashSet<>();

    public Mermaid(BaseHuman baseHuman, Fish fish) {
        super(baseHuman.getName().substring(0, 1).toUpperCase() + baseHuman.getName().substring(1).toLowerCase() + fish.getName().toLowerCase());
        this.mana = 0;
        this.swimmingState = baseHuman.getSwimmingState();
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public Collection<Spell> getSpells() {
        return spells;
    }

    @Override
    public void addSpell(Spell spell) {
        if (spell.getSpellType() != SpellType.WATER && spell.getSpellType() != SpellType.NEUTRAL) {
            System.out.println(getName() + " forgot the spell " + spell.name() + ".");
        } else {
            spells.add(spell);
        }
    }

    @Override
    public void castSpell(Spell spell) {
        if (!spells.contains(spell)) {
            System.out.println(getName() + " does not know " + spell.name() + ".");
        } else if (mana < spell.getManaCost()) {
            System.out.println(getName() + " does not have enough mana.");
        } else {
            mana -= spell.getManaCost();
            System.out.println(getName() + " casted " + spell.name() + ".");
        }
    }

    @Override
    public void regenMana(int mana) {
        this.mana += mana;
    }

    @Override
    public void swim() {
        swimmingState = true;
        System.out.println("I'm a Mermaid and I'm swimming.");
    }

    @Override
    public boolean getSwimmingState() {
        return swimmingState;
    }

    @Override
    public void emerge() {
        swimmingState = false;
        //System.out.println(getName() + "Emerges from the water.");
    }
}
