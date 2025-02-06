package fr.epita.assistants.grades.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Student(String name, int age, List<Grade> grades) {

    public static class StudentBuilder {
        private String name;
        private int age;
        private List<Grade> grades;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder grades(List<Grade> grades) {
            this.grades = grades;
            return this;
        }

        public Student build() {
            return new Student(name, age, grades);
        }

        @Override
        public String toString() {
            return "Student{name='"+ name +"' age="+ age +" grades="+ grades +"}";
        }
    }
}
