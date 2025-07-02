/*
 * 제네릭(Generics) & 와일드카드 심화
 * - 타입 파라미터, 제한된 제네릭, 와일드카드 실전 예제
 */
import java.util.*;

public class GenericsWildcardExamples {
    // 제네릭 메서드
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    // 와일드카드: 상한 제한
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    // 와일드카드: 하한 제한
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("A", "B");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Number> numList = new ArrayList<>(Arrays.asList(1, 2.5, 3));

        printList(strList);
        printNumbers(intList);
        addIntegers(numList);
        System.out.println(numList);
    }
} 