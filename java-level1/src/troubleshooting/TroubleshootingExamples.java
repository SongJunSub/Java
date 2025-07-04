/*
 * 실전 트러블슈팅/장애 대응
 * - Deadlock, OutOfMemory, Connection Leak 등 재현 및 해결법
 * - 로그 분석, 힙/스레드 덤프 분석 실습
 */

// Deadlock 예제
class DeadlockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    public void method1() {
        synchronized (lock1) {
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized (lock2) {}
        }
    }
    public void method2() {
        synchronized (lock2) {
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized (lock1) {}
        }
    }
}

public class TroubleshootingExamples {
    public static void main(String[] args) {
        // Deadlock 재현 (실행 시 주의)
        DeadlockDemo demo = new DeadlockDemo();
        new Thread(demo::method1).start();
        new Thread(demo::method2).start();
        System.out.println("Deadlock 발생 시 jstack, jvisualvm 등으로 분석");
        // OOM, Connection Leak 등은 별도 환경에서 실습 필요
    }
} 