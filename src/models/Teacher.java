package models;

public class Teacher extends Person {

    private String subject;
    private int YearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.YearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(int percentage) {
        salary += salary * percentage / 100;
    }

    public int getYearsOfExperience() {
        return YearsOfExperience;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ". My salary is " + salary + ".";
    }

}
