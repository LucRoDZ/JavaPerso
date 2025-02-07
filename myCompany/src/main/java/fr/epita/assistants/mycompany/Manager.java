package fr.epita.assistants.mycompagny;

import java.util.HashSet;
import java.util.Set;

class Manager extends Employee implements Assignable {
    private Set<String> projects = new HashSet<>();


    public Manager(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.println(getFirstName() + " " + getLastName() + " is a manager.");
    }

    @Override
    public void addProject(String project) {
        projects.add(project);
    }

    @Override
    public boolean hasProject(String project) {
        return projects.contains(project);
    }

    @Override
    public void listProjects() {
        if (!projects.isEmpty()) {
            System.out.println(getFirstName() + " " + getLastName() + "'s current projects are:");
            for (String project : projects) {
                System.out.println("- " + project);
            }
        }
    }
}
