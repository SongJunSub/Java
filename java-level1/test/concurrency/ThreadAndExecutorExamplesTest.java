package concurrency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ConcurrentMap;

public class ThreadAndExecutorExamplesTest {

    private final ThreadAndExecutorExamples examples = new ThreadAndExecutorExamples();

    @Test
    void testRunExecutorService() throws ExecutionException, InterruptedException {
        assertEquals(30, examples.runExecutorService());
    }

    @Test
    void testRunSynchronizedCounter() throws InterruptedException {
        // Due to the nature of multithreading and potential for context switching,
        // the exact final count might vary slightly if not perfectly synchronized.
        // However, with synchronized method, it should ideally be 2000.
        assertEquals(2000, examples.runSynchronizedCounter());
    }

    @Test
    void testRunLockCounter() throws InterruptedException {
        // Similar to synchronized counter, with Lock, it should ideally be 2000.
        assertEquals(2000, examples.runLockCounter());
    }

    @Test
    void testGetConcurrentMap() {
        ConcurrentMap<String, Integer> cmap = examples.getConcurrentMap();
        assertNotNull(cmap);
        assertEquals(1, cmap.get("A"));
    }
}
