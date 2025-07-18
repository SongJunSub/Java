package concurrency;

import java.util.concurrent.*;
import java.util.*;

public class ThreadAndExecutorExamples {

    // 1. Thread & Runnable
    public void runThread() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("스레드1 실행"));
        t1.start();
        t1.join();
    }

    // 2. ExecutorService & Future
    public int runExecutorService() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(() -> 10 + 20);
        int result = future.get();
        executor.shutdown();
        return result;
    }

    // 3. 동기화(synchronized)
    public int runSynchronizedCounter() throws InterruptedException {
        Counter counter = new Counter();
        Thread t2 = new Thread(counter::increment);
        Thread t3 = new Thread(counter::increment);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
        return counter.getCount();
    }

    // 4. Lock 사용
    public int runLockCounter() throws InterruptedException {
        LockCounter lockCounter = new LockCounter();
        Thread t4 = new Thread(lockCounter::increment);
        Thread t5 = new Thread(lockCounter::increment);
        t4.start();
        t5.start();
        t4.join();
        t5.join();
        return lockCounter.getCount();
    }

    // 5. 동시성 컬렉션
    public ConcurrentMap<String, Integer> getConcurrentMap() {
        ConcurrentMap<String, Integer> cmap = new ConcurrentHashMap<>();
        cmap.put("A", 1);
        return cmap;
    }

    // 동기화 예제
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            for (int i = 0; i < 1000; i++) count++;
        }

        public int getCount() {
            return count;
        }
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

        public int getCount() {
            return count;
        }
    }
}