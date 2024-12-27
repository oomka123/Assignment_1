package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }

    public void sortStudents() {
        members.sort(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student student1 = (Student) o1;
                    Student student2 = (Student) o2;

                    return Double.compare(student2.calculateGPA(), student1.calculateGPA());
                }

                if (o1 instanceof Student) {
                    return -1;
                } else if (o2 instanceof Student) {
                    return 1;
                }

                return 0;
            }
        });
    }


}
