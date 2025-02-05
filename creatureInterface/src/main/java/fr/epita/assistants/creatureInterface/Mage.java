package fr.epita.assistants.creatureInterface;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Mage extends BaseHuman implements MagicalInterface {
    private int mana;
    private Set<Spell> spells = new HashSet<>();

    public Mage(String name, int mana) {
        super(name);
        this.mana = mana;
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
        spells.add(spell);
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
}

