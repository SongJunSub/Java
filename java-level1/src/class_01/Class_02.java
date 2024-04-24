package class_01;

/*
    String -> String[]
 */

public class Class_02 {

    public static void main(String[] args) {
        final String[] studentNames = {"송준섭", "이철한"};
        final int[] studentAges = {34, 33};
        final int[] studentGrades = {90, 80};

        for(int i=0; i<studentNames.length; i++){
            System.out.println("Name : " + studentNames[i] + "\n" + "Age : " + studentAges[i] + "\n" + "Grade : " + studentGrades[i]);
        }
    }

}