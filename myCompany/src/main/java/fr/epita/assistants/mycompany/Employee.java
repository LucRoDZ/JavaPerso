package fr.epita.assistants.mycompagny;

import java.util.*;

abstract class Employee {
    private String firstName;
    private String lastName;

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void sayMyName() {
        System.out.println("My name is " + firstName + " " + lastName + ".");
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public abstract void sayMyJob();
}
