import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* Producer - Consumer. Not thread safe. Thread safe is implemented manually. (synchronised block)
* */

public class ProducerConsumerManager_V2 {
    public static void main(String[] args) {
        ExecutorService threadPoolProducer = Executors.newFixedThreadPool(2);
        ExecutorService threadPoolConsumer = Executors.newFixedThreadPool(2);

        threadPoolProducer.submit(() -> {
            try {
                WorkProducerConsumer.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolConsumer.submit(() -> {
            try {
                WorkProducerConsumer.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolProducer.shutdown();
        threadPoolConsumer.shutdown();
    }
}

class WorkProducerConsumer {
    private static Queue<Integer> queue = new LinkedList<>();
    private static final Object LOCK = new Object();
    private static final int QUEUE_CAPACITY = 5;

    static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            synchronized (LOCK) {
                if (queue.size() == QUEUE_CAPACITY) {
                    LOCK.wait();
                }

                System.out.println("Added: " + queue.offer(random.nextInt(100)) + ". " + Thread.currentThread().getName());
                System.out.println("Queue size: " + queue.size());
                LOCK.notifyAll();
            }
        }
    }

    static void consumer() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {
                if (queue.size() == 0) {
                    LOCK.wait();
                }

                System.out.println("Take value: " + queue.poll() + ". " + Thread.currentThread().getName());
                System.out.println("Queue size: " + queue.size() + "\n");
                LOCK.notifyAll();
            }

            Thread.sleep(1000);
        }
    }
}

