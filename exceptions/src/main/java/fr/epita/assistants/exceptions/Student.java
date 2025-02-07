package fr.epita.assistants.exceptions;

class Student {
    private String name;
    private int age;
    private String major;

    private static final String[] EPITA_MAJORS = {
            "IMAGE", "CP", "SRS", "SCIA", "MTI", "TCOM", "SIGL", "GITM", "SANTE", "SSIE", "IF", "Q", "SCIA-G"
    };

    public Student(String name, int age, String major) throws InvalidNameException, InvalidAgeException, InvalidMajorException {
        if (name.matches(".*\\d.*")) {
            throw new InvalidNameException(name);
        }
        if (age <= 0 || age >= 130) {
            throw new InvalidAgeException(age);
        }
        boolean AvalidMajor = false;
        for (String allowed : EPITA_MAJORS) {
            if (allowed.equalsIgnoreCase(major)) {
                AvalidMajor = true;
                this.major = allowed.toUpperCase();
                break;
            }
        }
        if (!AvalidMajor) {
            throw new InvalidMajorException(major);
        }

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}

