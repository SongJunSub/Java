package pattern;

import java.util.*;

/*
 * 디자인 패턴 심화
 * - 싱글턴, 팩토리, 전략, 옵저버, 데코레이터, 빌더 패턴 예제
 */

// 1. 싱글턴 패턴
class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return INSTANCE; }
}

// 2. 팩토리 패턴
interface Product { String getName(); }
class ProductA implements Product { public String getName() { return "A"; } }
class ProductB implements Product { public String getName() { return "B"; } }
class ProductFactory {
    public static Product create(String type) {
        return switch(type) {
            case "A" -> new ProductA();
            case "B" -> new ProductB();
            default -> throw new IllegalArgumentException();
        };
    }
}

// 3. 전략 패턴
interface Strategy { int operate(int a, int b); }
class AddStrategy implements Strategy { public int operate(int a, int b) { return a + b; } }
class MultiplyStrategy implements Strategy { public int operate(int a, int b) { return a * b; } }
class Context {
    private Strategy strategy;
    public Context(Strategy strategy) { this.strategy = strategy; }
    public int execute(int a, int b) { return strategy.operate(a, b); }
}

// 4. 옵저버 패턴
interface Observer { void update(String msg); }
class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) { observers.add(o); }
    public void notifyObservers(String msg) { observers.forEach(o -> o.update(msg)); }
}
class ConcreteObserver implements Observer {
    public void update(String msg) { System.out.println("알림: " + msg); }
}

// 5. 데코레이터 패턴
interface Coffee { String getDesc(); }
class BasicCoffee implements Coffee { public String getDesc() { return "커피"; } }
class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDesc() { return coffee.getDesc() + "+우유"; }
}

// 6. 빌더 패턴
class User {
    private String name; private int age;
    private User(Builder b) { this.name = b.name; this.age = b.age; }
    public static class Builder {
        private String name; private int age;
        public Builder name(String n) { this.name = n; return this; }
        public Builder age(int a) { this.age = a; return this; }
        public User build() { return new User(this); }
    }
    public String toString() { return name + ", " + age; }
}

public class DesignPatternExamples {
    public static void main(String[] args) {
        // 싱글턴
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("싱글턴 동일 인스턴스: " + (s1 == s2));

        // 팩토리
        Product p = ProductFactory.create("A");
        System.out.println("팩토리 생성: " + p.getName());

        // 전략
        Context ctx = new Context(new AddStrategy());
        System.out.println("전략(덧셈): " + ctx.execute(2, 3));

        // 옵저버
        Subject subject = new Subject();
        subject.addObserver(new ConcreteObserver());
        subject.notifyObservers("이벤트 발생!");

        // 데코레이터
        Coffee coffee = new MilkDecorator(new BasicCoffee());
        System.out.println("데코레이터: " + coffee.getDesc());

        // 빌더
        User user = new User.Builder().name("홍길동").age(30).build();
        System.out.println("빌더: " + user);
    }
}