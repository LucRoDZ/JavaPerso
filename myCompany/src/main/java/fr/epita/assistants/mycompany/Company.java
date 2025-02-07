package fr.epita.assistants.mycompagny;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Company {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private Map<Employee, Manager> employeeManagement = new HashMap<>();

    public Company(String name) {
        this.name = name;
    }

    public int size() {
        return employees.size();
    }

    public void hire(Employee p) {
        employees.add(p);
    }

    public void fire(Employee p) {
        employees.remove(p);
    }

    public void printEmployees() {
        System.out.println("The company " + name + " employs:");
        for (Employee e : employees) {
            System.out.println("- " + e);
        }
    }


    public boolean addEmployeeManagement(Employee e, Manager m) {
        if (!employees.contains(e)) {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " is not employed by " + name + ".");
            return false;
        }
        if (!employees.contains(m)) {
            System.out.println(m.getFirstName() + " " + m.getLastName() + " is not employed by " + name + ".");
            return false;
        }
        if (employeeManagement.containsKey(e)) {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " has a new manager.");
        } else {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " now has a manager.");
        }
        employeeManagement.put(e, m);
        return true;
    }

    public void printManager(Employee e) {
        if (employeeManagement.containsKey(e)) {
            Manager m = employeeManagement.get(e);
            System.out.println(m.getFirstName() + " " + m.getLastName() + " manages " + e.getFirstName() + " " + e.getLastName() + ".");
        } else {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " is managed by nobody.");
        }
    }

    public void printEmployeesProject() {
        for (Employee e : employees) {
            if (e instanceof Assignable) {
                ((Assignable) e).listProjects();
            }
        }
    }
}

