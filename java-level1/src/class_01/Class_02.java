package class_01;

/*
    * 배열 사용의 한계
     - 데이터가 변경될 때 각각의 배열마다 인덱스 순서를 정확하게 찾아서 제거해줘야 한다.
 */

public class Class_02 {

    public static void main(String[] args) {
        final String[] studentNames = {"Song", "Lee"};
        final int[] studentAges = {34, 33};
        final int[] studentGrades = {90, 80};

        for(int i=0; i<studentNames.length; i++){
            System.out.println("Name : " + studentNames[i] + "\n" + "Age : " + studentAges[i] + "\n" + "Grade : " + studentGrades[i]);
        }
    }

}