package models;

import java.util.ArrayList;
import static java.util.Map.entry;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private List<Integer> grades;

    private static final Map<Integer, Double> gradesToGPA = Map.ofEntries(
            entry(100, 4.0),
            entry(95, 4.0),
            entry(90, 3.67),
            entry(85, 3.33),
            entry(80, 3.0),
            entry(75, 2.67),
            entry(70, 2.33),
            entry(65, 2.0),
            entry(60, 1.67),
            entry(55, 1.33),
            entry(50, 1.0)
    );

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

    public static double convertToGPA(double averageGrade) {

        int roundedGrade = (int) (Math.round(averageGrade / 5.0) * 5);

        return gradesToGPA.getOrDefault(roundedGrade, 0.0);
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }

}
