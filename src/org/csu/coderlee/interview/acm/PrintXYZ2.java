package org.csu.coderlee.interview.acm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintXYZ2 {

    static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (count.get() == 1) {
                            System.out.print("x");
                            count.getAndSet(2);
                            break;
                        }
                    }
                }
            });
            es.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (count.get() == 2) {
                            System.out.print("y");
                            count.getAndSet(3);
                            break;
                        }
                    }
                }
            });
            es.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (count.get() == 3) {
                            System.out.print("z");
                            System.out.println("");
                            count.getAndSet(1);
                            break;
                        }
                    }
                }
            });
        }
        es.shutdown();

    }

}
