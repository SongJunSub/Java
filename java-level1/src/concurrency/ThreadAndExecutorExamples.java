package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class ThreadAndExecutorExamples {

    // 1. Thread & Runnable
    public void runThread() throws InterruptedException {
        System.out.println("\n--- 1. Thread & Runnable ---");
        Thread t1 = new Thread(() -> System.out.println("스레드1 실행"));
        t1.start();
        t1.join();
        System.out.println("스레드1 종료");
    }

    // 2. ExecutorService & Future
    public int runExecutorService() throws ExecutionException, InterruptedException {
        System.out.println("\n--- 2. ExecutorService & Future ---");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Callable: 값을 반환하고 예외를 던질 수 있는 태스크
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Callable 태스크 실행 중...");
            Thread.sleep(500);
            return 10 + 20;
        });
        int result = future.get(); // 결과가 올 때까지 블로킹
        System.out.println("ExecutorService 결과: " + result);
        executor.shutdown();
        System.out.println("ExecutorService 종료");
        return result;
    }

    // 3. 동기화(synchronized)
    public int runSynchronizedCounter() throws InterruptedException {
        System.out.println("\n--- 3. 동기화(synchronized) ---");
        Counter counter = new Counter();
        Thread t2 = new Thread(counter::increment);
        Thread t3 = new Thread(counter::increment);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
        System.out.println("Synchronized Counter 최종 값: " + counter.getCount());
        return counter.getCount();
    }

    // 4. Lock 사용
    public int runLockCounter() throws InterruptedException {
        System.out.println("\n--- 4. Lock 사용 ---");
        LockCounter lockCounter = new LockCounter();
        Thread t4 = new Thread(lockCounter::increment);
        Thread t5 = new Thread(lockCounter::increment);
        t4.start();
        t5.start();
        t4.join();
        t5.join();
        System.out.println("Lock Counter 최종 값: " + lockCounter.getCount());
        return lockCounter.getCount();
    }

    // 5. 동시성 컬렉션
    public ConcurrentMap<String, Integer> getConcurrentMap() {
        System.out.println("\n--- 5. 동시성 컬렉션 ---");
        ConcurrentMap<String, Integer> cmap = new ConcurrentHashMap<>();
        cmap.put("A", 1);
        cmap.put("B", 2);
        System.out.println("ConcurrentMap: " + cmap);
        return cmap;
    }

    // 6. Semaphore (세마포어)
    // - 동시에 접근할 수 있는 스레드 수를 제한할 때 사용.
    // - 리소스 풀 관리, 동시성 제어에 유용.
    public void runSemaphoreExample() throws InterruptedException {
        System.out.println("\n--- 6. Semaphore ---");
        Semaphore semaphore = new Semaphore(2); // 동시에 2개의 스레드만 접근 허용
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    semaphore.acquire(); // 허가 획득
                    System.out.println("Task " + taskId + " is performing work.");
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " finished work.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release(); // 허가 반납
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Semaphore Example Finished.");
    }

    // 7. CountDownLatch (카운트다운 래치)
    // - 하나 이상의 스레드가 다른 스레드에서 수행되는 작업을 완료할 때까지 기다리도록 함.
    // - 여러 선행 작업이 완료될 때까지 메인 스레드가 기다려야 할 때 유용.
    public void runCountDownLatchExample() throws InterruptedException {
        System.out.println("\n--- 7. CountDownLatch ---");
        CountDownLatch latch = new CountDownLatch(3); // 3개의 작업이 완료될 때까지 기다림
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            final int workerId = i;
            executor.submit(() -> {
                System.out.println("Worker " + workerId + " started.");
                try { Thread.sleep((long) (Math.random() * 1000)); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("Worker " + workerId + " finished.");
                latch.countDown(); // 카운트 감소
            });
        }

        System.out.println("Main thread waiting for workers to finish...");
        latch.await(); // 모든 작업이 완료될 때까지 대기
        System.out.println("All workers finished. Main thread continues.");
        executor.shutdown();
    }

    // 8. CyclicBarrier (사이클릭 배리어)
    // - 여러 스레드가 특정 지점(장벽)에 도달할 때까지 기다린 다음, 모든 스레드가 동시에 작업을 계속하도록 함.
    // - 여러 단계로 구성된 병렬 계산에서 각 단계의 시작을 동기화할 때 유용.
    public void runCyclicBarrierExample() throws BrokenBarrierException, InterruptedException {
        System.out.println("\n--- 8. CyclicBarrier ---");
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("모든 스레드가 장벽에 도달했습니다. 다음 단계 시작!"));
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            final int participantId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Participant " + participantId + " reached barrier 1.");
                    barrier.await(); // 첫 번째 장벽 대기

                    System.out.println("Participant " + participantId + " reached barrier 2.");
                    barrier.await(); // 두 번째 장벽 대기

                    System.out.println("Participant " + participantId + " finished.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("CyclicBarrier Example Finished.");
    }

    // 9. Atomic 변수 (AtomicInteger)
    // - 락 없이 스레드 안전한 연산을 제공. CAS(Compare-And-Swap) 연산 사용.
    // - 동기화 오버헤드를 줄여 성능 향상.
    public int runAtomicIntegerExample() throws InterruptedException {
        System.out.println("\n--- 9. Atomic 변수 (AtomicInteger) ---");
        AtomicInteger atomicCounter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executor.submit(atomicCounter::incrementAndGet);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("AtomicInteger 최종 값: " + atomicCounter.get());
        return atomicCounter.get();
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

    public static void main(String[] args) throws Exception {
        ThreadAndExecutorExamples examples = new ThreadAndExecutorExamples();

        examples.runThread();
        examples.runExecutorService();
        examples.runSynchronizedCounter();
        examples.runLockCounter();
        examples.getConcurrentMap();
        examples.runSemaphoreExample();
        examples.runCountDownLatchExample();
        examples.runCyclicBarrierExample();
        examples.runAtomicIntegerExample();
    }
}
