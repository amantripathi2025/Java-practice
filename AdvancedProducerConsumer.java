import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AdvancedProducerConsumer {

    private static final int QUEUE_CAPACITY = 5;
    private static final int PRODUCERS = 2;
    private static final int CONSUMERS = 2;
    private static final int ITEMS_PER_PRODUCER = 10;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        ExecutorService executor = Executors.newFixedThreadPool(PRODUCERS + CONSUMERS);
        AtomicInteger counter = new AtomicInteger(1);

        for (int i = 1; i <= PRODUCERS; i++) {
            final int producerId = i;
            executor.submit(() -> {
                try {
                    for (int j = 0; j < ITEMS_PER_PRODUCER; j++) {
                        int item = counter.getAndIncrement();
                        queue.put(item);
                        System.out.println("Producer " + producerId + " produced: " + item);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (int i = 1; i <= CONSUMERS; i++) {
            final int consumerId = i;
            executor.submit(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Integer item = queue.take();
                        System.out.println("Consumer " + consumerId + " consumed: " + item);
                        Thread.sleep(150);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed.");
    }
}