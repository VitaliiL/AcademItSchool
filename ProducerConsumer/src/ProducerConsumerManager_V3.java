import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerManager_V3 {
    private Queue<Integer> queue = new LinkedList<>();
    private static final Object LOCK = new Object();
    private static final int QUEUE_CAPACITY = 5;
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        new ProducerConsumerManager_V3().startThread();
    }

    private void startThread() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread threadProducer = new Thread(() -> {
                try {
                    addValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            threadProducer.start();

            Thread threadConsumer = new Thread(() -> {
                try {
                    takeValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threadConsumer.start();
        }
    }

    private void addValue() throws InterruptedException {
        Random random = new Random();

        while (true) {
            synchronized (LOCK) {
                if (queue.size() == QUEUE_CAPACITY) {
                    LOCK.wait();
                }

                Thread.sleep(100);
                System.out.println("Added: " + queue.offer(random.nextInt(100)) + ". " + Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

    private void takeValue() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {
                if (queue.size() == 0) {
                    LOCK.wait();
                }

                Thread.sleep(1000);
                System.out.println("Take value: " + queue.poll() + ". " + Thread.currentThread().getName());
                System.out.println("Queue size: " + queue.size());
                LOCK.notifyAll();
            }
        }
    }
}

//class Producer implements Runnable {
//    private final ProducerConsumerManager_V3 manager_v2;
//
//    Producer(ProducerConsumerManager_V3 manager_v2) {
//        this.manager_v2 = manager_v2;
//    }
//
//    @Override
//    public void run() {
//        try {
//            manager_v2.addValue();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    private final ProducerConsumerManager_V3 manager_v2;
//
//    Consumer(ProducerConsumerManager_V3 manager_v2) {
//        this.manager_v2 = manager_v2;
//    }
//
//    @Override
//    public void run() {
//        try {
//            manager_v2.takeValue();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}


