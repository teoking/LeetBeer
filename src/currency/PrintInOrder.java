package currency;

import java.util.concurrent.CountDownLatch;

/**
 * Lc1114
 */
class PrintInOrder {

    private final CountDownLatch latch2 = new CountDownLatch(1);
    private final CountDownLatch latch3 = new CountDownLatch(1);

    public PrintInOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        PrintInOrder pio = new PrintInOrder();
        Runnable printFirst = () -> System.out.println("First");
        Runnable printSecond = () -> System.out.println("Second");
        Runnable printThird = () -> System.out.println("Third");

        Thread t1 = new Thread(() -> {
            try {
                pio.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pio.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                pio.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t1.start();
        t2.start();
    }

}

