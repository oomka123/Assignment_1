package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private  List<Integer> grades;

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

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return convertToGPA(sum / grades.size());
    }

    private static double convertToGPA(double averageGrade) {
        if (averageGrade >= 93) {
            return 4.0;
        } else if (averageGrade >= 90) {
            return 3.67;
        } else if (averageGrade >= 87) {
            return 3.33;
        } else if (averageGrade >= 83) {
            return 3.0;
        } else if (averageGrade >= 80) {
            return 2.67;
        } else if (averageGrade >= 77) {
            return 2.33;
        } else if (averageGrade >= 73) {
            return 2.0;
        } else if (averageGrade >= 70) {
            return 1.67;
        } else if (averageGrade >= 67) {
            return 1.33;
        } else if (averageGrade >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }

}
