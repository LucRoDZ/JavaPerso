package fr.epita.assistants.drawing;

import lombok.Getter;

@Getter
public abstract class Entity {
    private static long SEQUENCE = 0;
    protected final long id;

    public Entity() {
        id = ++SEQUENCE;
    }

    long getId() {

        return id;
    }

    void draw() {
    }
}
