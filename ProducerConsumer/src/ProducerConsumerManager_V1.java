import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Producer - Consumer. Thread safe. Thread safe is implemented using thread safe objects and methods.
 */

public class ProducerConsumerManager_V1 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

        ExecutorService threadPoolProducer = Executors.newFixedThreadPool(2);
        ExecutorService threadPoolConsumer = Executors.newFixedThreadPool(2);

        threadPoolProducer.submit(() -> {
            Random random = new Random();
            while (true) {
                try {
                    queue.put(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPoolConsumer.submit(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println("Take value from queue: " + queue.take() + ". " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Queue size is " + queue.size());
            }
        });

        threadPoolProducer.shutdown();
        threadPoolConsumer.shutdown();
    }
}