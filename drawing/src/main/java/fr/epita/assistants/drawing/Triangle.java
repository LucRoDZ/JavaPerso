package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    public Triangle(int size) {
         super(size);
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == length - 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
