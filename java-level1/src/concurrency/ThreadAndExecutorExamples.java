/*
 * 멀티스레드 & 동기화 심화
 * - Thread, Runnable, ExecutorService, Future, 동기화(synchronized, Lock), 동시성 컬렉션
 */
import java.util.concurrent.*;
import java.util.*;

public class ThreadAndExecutorExamples {
    public static void main(String[] args) throws Exception {
        // 1. Thread & Runnable
        Thread t1 = new Thread(() -> System.out.println("스레드1 실행"));
        t1.start();
        t1.join();

        // 2. ExecutorService & Future
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(() -> 10 + 20);
        System.out.println("Future 결과: " + future.get());
        executor.shutdown();

        // 3. 동기화(synchronized)
        Counter counter = new Counter();
        Thread t2 = new Thread(() -> counter.increment());
        Thread t3 = new Thread(() -> counter.increment());
        t2.start(); t3.start();
        t2.join(); t3.join();
        System.out.println("동기화 카운터: " + counter.getCount());

        // 4. Lock 사용
        LockCounter lockCounter = new LockCounter();
        Thread t4 = new Thread(() -> lockCounter.increment());
        Thread t5 = new Thread(() -> lockCounter.increment());
        t4.start(); t5.start();
        t4.join(); t5.join();
        System.out.println("Lock 카운터: " + lockCounter.getCount());

        // 5. 동시성 컬렉션
        ConcurrentMap<String, Integer> cmap = new ConcurrentHashMap<>();
        cmap.put("A", 1);
        System.out.println("ConcurrentMap: " + cmap);
    }

    // 동기화 예제
    static class Counter {
        private int count = 0;
        public synchronized void increment() {
            for (int i = 0; i < 1000; i++) count++;
        }
        public int getCount() { return count; }
    }

    // Lock 예제
    static class LockCounter {
        private int count = 0;
        private final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
        public void increment() {
            lock.lock();
            try {
                for (int i = 0; i < 1000; i++) count++;
            } finally {
                lock.unlock();
            }
        }
        public int getCount() { return count; }
    }
} 