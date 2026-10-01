import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Virtual threads (Java 21+) let you write blocking I/O style code
 * without tying up a platform thread per request.
 */
public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.rangeClosed(1, 20).forEach(i -> executor.submit(() -> {
                try {
                    Thread.sleep(50);
                    System.out.println("task " + i + " on " + Thread.currentThread());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }));
        }
        long ms = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        System.out.println("finished in " + ms + " ms");
    }
}
