package fr.epita.assistants.drawing;

public class Triangle extends Entity implements IDrawable {
    private final int size;

    public Triangle(int size) {
        this.size = size;
    }

    @Override
    public void draw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == size - 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
