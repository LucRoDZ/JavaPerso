package fr.epita.assistants.drawing;

public abstract class Sharp extends Entity implements IDrawable {
    protected final int length;

    protected Sharp(int length) {
        this.length = length;
    }

    @Override
    public abstract void draw();
}
