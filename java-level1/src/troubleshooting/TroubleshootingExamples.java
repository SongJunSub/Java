import java.util.*;
/*
 * 실전 트러블슈팅/장애 대응 (심화)
 * - Deadlock, OutOfMemory, Connection Leak 등 재현 및 해결법
 * - jstack, jmap, jvisualvm 활용법
 * - 장애 리포트 샘플
 */

// Deadlock 실전 분석 예제
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

// 메모리 릭 재현 예제
class MemoryLeakDemo {
    static List<byte[]> leakyList = new ArrayList<>();
    public static void leak() {
        for (int i = 0; i < 1000; i++) {
            leakyList.add(new byte[1024 * 1024]); // 1MB씩 누수
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

        // 메모리 릭 재현 (실행 시 주의)
        // MemoryLeakDemo.leak();
        // System.out.println("메모리 릭 발생 후 jmap, jvisualvm 등으로 분석");

        // 장애 리포트 샘플
        System.out.println("[장애 리포트 예시]\n- 장애 시간: 2025-07-01 14:00~14:10\n- 증상: 서비스 응답 지연 및 다운\n- 원인: Deadlock 발생, GC Full 발생\n- 조치: 프로세스 재기동, 코드 동기화 개선\n- 재발 방지: Lock 순서 일관성, 모니터링 강화");
    }
} 