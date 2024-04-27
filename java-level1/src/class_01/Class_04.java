package class_01;

public class Class_04 {

    public static void main(String[] args) {
        Student student01 = new Student();
        student01.name = "Song";
        student01.age = 34;
        student01.grade = 90;

        Student student02 = new Student();
        student02.name = "Lee";
        student02.age = 33;
        student02.grade = 80;

        Student[] students = new Student[2];
        students[0] = student01;
        students[1] = student02;

        System.out.println("Name : " + students[0].name + "\n" + "Age : " + students[0].age + "\n" + "Grade : " + students[0].grade);
        System.out.println("Name : " + students[1].name + "\n" + "Age : " + students[1].age + "\n" + "Grade : " + students[1].grade);
    }

}