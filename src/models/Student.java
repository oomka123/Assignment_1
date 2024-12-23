package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade){
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        }
    }

    public double calculateGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    public static double convertToGPA(double grade) {
        if (grade >= 90 && grade <= 100) {
            return 4.0;
        } else if (grade >= 80 && grade < 90) {
            return 3.0 + (grade - 80) * 0.1;
        } else if (grade >= 70 && grade < 80) {
            return 2.0 + (grade - 70) * 0.1;
        } else if (grade >= 60 && grade < 70) {
            return 1.0 + (grade - 60) * 0.1;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }

}
