package fr.epita.assistants.creatureInterface;

import fr.epita.assistants.creatureInterface.*;
import java.util.*;

public abstract class BaseHuman extends Creature implements SpeakableInterface, SwimmingInterface {
    private boolean swimmingState;

    public BaseHuman(String name) {
        super(name);
        this.swimmingState = false;
    }

    @Override
    public void swim() {
        swimmingState = true;
        System.out.println("I'm a " + getClass().getSimpleName() + " and I'm swimming.");
    }

    @Override
    public boolean getSwimmingState() {
        return swimmingState;
    }

    @Override
    public void emerge() {
        swimmingState = false;
        System.out.println(getName() + " has emerged from the water.");
    }

    @Override
    public void hello() {
        System.out.println("Hello, my name is " + getName() + " and I'm a " + getClass().getSimpleName() + ".");
    }

}