package fr.epita.assistants.exceptions;

public class Main {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Jean-Michel", 19, "iMAgE");
            System.out.println(student1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student student2 = new Student("K3vin", 21, "mti");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student student3 = new Student("Paul", -2, "cp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student student4 = new Student("Maxime", 21, "unknown");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
