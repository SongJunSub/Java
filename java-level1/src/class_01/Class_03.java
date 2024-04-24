package class_01;

public class Class_03 {

    public static void main(String[] args) {
        Student student01 = new Student();
        student01.name = "송준섭";
        student01.age = 34;
        student01.grade = 90;

        Student student02 = new Student();
        student02.name = "이철한";
        student02.age = 33;
        student02.grade = 80;

        System.out.println("Name : " + student01.name + "\n" + "Age : " + student01.age + "\n" + "Grade : " + student01.grade);
        System.out.println("Name : " + student02.name + "\n" + "Age : " + student02.age + "\n" + "Grade : " + student02.grade);
    }

}