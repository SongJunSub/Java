// Java 핵심 주제별 예제 코드 모음
public class JavaCoreExamples {
    // 1. 변수와 자료형
    public void variableExamples() {
        int number = 10;
        double pi = 3.14;
        char grade = 'A';
        boolean isJavaFun = true;
        String message = "Hello, Java!";
        System.out.println(number + ", " + pi + ", " + grade + ", " + isJavaFun + ", " + message);
    }

    // 2. 조건문
    public void conditionExamples(int age, char grade) {
        if (age >= 18) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }
        switch (grade) {
            case 'A':
                System.out.println("우수");
                break;
            case 'B':
                System.out.println("보통");
                break;
            default:
                System.out.println("기타");
        }
    }

    // 3. 반복문
    public void loopExamples() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello " + i);
        }
        int count = 0;
        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }
    }

    // 4. 배열
    public void arrayExamples() {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int n : numbers) {
            System.out.println(n);
        }
    }

    // 5. 메서드
    public int add(int a, int b) {
        return a + b;
    }

    // 6. 클래스와 객체
    static class Person {
        String name;
        int age;
        void sayHello() {
            System.out.println("안녕하세요, " + name + "입니다.");
        }
    }

    // 7. 상속
    static class Animal {
        void sound() {
            System.out.println("동물 소리");
        }
    }
    static class Dog extends Animal {
        void sound() {
            System.out.println("멍멍");
        }
    }

    // 8. 인터페이스
    interface Drawable {
        void draw();
    }
    static class Circle implements Drawable {
        public void draw() {
            System.out.println("원을 그립니다.");
        }
    }

    // 9. 예외 처리
    public void exceptionExample() {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } finally {
            System.out.println("항상 실행됩니다.");
        }
    }

    // 10. 컬렉션 (ArrayList)
    public void collectionExample() {
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        list.add("사과");
        list.add("바나나");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }

    // 11. 스트림 (Stream)
    public void streamExample() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = java.util.Arrays.stream(arr).sum();
        System.out.println(sum);
    }

    // 12. 람다식
    interface MyFunc {
        int calc(int x, int y);
    }
    public void lambdaExample() {
        MyFunc f = (x, y) -> x + y;
        System.out.println(f.calc(3, 4));
    }

    public static void main(String[] args) {
        JavaCoreExamples ex = new JavaCoreExamples();
        ex.variableExamples();
        ex.conditionExamples(20, 'B');
        ex.loopExamples();
        ex.arrayExamples();
        System.out.println(ex.add(3, 5));
        Person p = new Person();
        p.name = "홍길동";
        p.age = 25;
        p.sayHello();
        Dog d = new Dog();
        d.sound();
        Circle c = new Circle();
        c.draw();
        ex.exceptionExample();
        ex.collectionExample();
        ex.streamExample();
        ex.lambdaExample();
    }
} 