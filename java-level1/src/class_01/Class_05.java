package class_01;

public class Class_05 {

    public static void main(String[] args) {
        Student student01 = new Student();
        student01.name = "Song";
        student01.age = 34;
        student01.grade = 90;

        Student student02 = new Student();
        student02.name = "Lee";
        student02.age = 33;
        student02.grade = 80;

        Student[] students = {student01, student02};

        for(int i=0; i<students.length; i++){
            Student student = students[i];
            System.out.println("Name : " + student.name + "\n" + "Age : " + student.age + "\n" + "Grade : " + student.grade);
        }

        for(Student student : students){
            System.out.println("Name : " + student.name + "\n" + "Age : " + student.age + "\n" + "Grade : " + student.grade);
        }
    }

}