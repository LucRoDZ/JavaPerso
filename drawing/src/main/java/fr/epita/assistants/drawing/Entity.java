package fr.epita.assistants.drawing;

public abstract class Entity {
    private static int SEQUENCE = 0;
    protected final int id;

    public Entity() {
        id = ++SEQUENCE;
    }

    public int getId() {
        return id;
    }
}
