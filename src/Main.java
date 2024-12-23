import models.Person;
import models.School;
import models.Student;
import models.Teacher;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File studentFile = new File("src/students.txt");
        Scanner studentScanner = new Scanner(studentFile);

        while (studentScanner.hasNext()) {
            String name = studentScanner.next();
            String surname = studentScanner.next();
            int age = studentScanner.nextInt();
            boolean gender = studentScanner.next().equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);

            while (studentScanner.hasNextInt()) {
                student.addGrade(studentScanner.nextInt());
            }

            school.addMember(student);
        }
        studentScanner.close();

        File teacherFile = new File("src/teachers.txt");
        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNext()) {
            String name = teacherScanner.next();
            String surname = teacherScanner.next();
            int age = teacherScanner.nextInt();
            boolean gender = teacherScanner.next().equalsIgnoreCase("Male");
            String subject = teacherScanner.next();
            int yearsOfExperience = teacherScanner.nextInt();
            int salary = teacherScanner.nextInt();

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            school.addMember(teacher);
        }
        teacherScanner.close();

        System.out.println("All members of the school:");
        System.out.println(school);

        for (Person member : school.getMembers()) {
            if (member instanceof Teacher teacher) {
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                }
            }
        }

        System.out.println("After the salary increase:");
        for (Person member : school.getMembers()) {
            if (member instanceof Teacher teacher) {
                System.out.println(teacher);
            }
        }

        System.out.println();

        for (Person member : school.getMembers()) {
            if (member instanceof Student student) {
                System.out.println(student.getName() + "'s GPA: " + student.calculateGrades());
            }
        }
    }
}