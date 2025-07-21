package class_01;

import java.util.ArrayList;
import java.util.List;

public class Class_05 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(createStudent("Song", 34, 90));
        students.add(createStudent("Lee", 33, 80));

        students.forEach(student -> System.out.println("Name : " + student.name + "\n" + "Age : " + student.age + "\n" + "Grade : " + student.grade));
    }

    private static Student createStudent(String name, int age, int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }

}