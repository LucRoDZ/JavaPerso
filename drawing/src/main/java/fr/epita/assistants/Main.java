package fr.epita.assistants;

import fr.epita.assistants.drawing.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List.of(new Rectangle(3,
                                4),
                new Square(10),
                new Triangle(5),
                new Circle(7))
            .forEach(IDrawable::draw);
    }
}
