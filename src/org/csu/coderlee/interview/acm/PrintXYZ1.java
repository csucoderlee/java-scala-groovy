package org.csu.coderlee.interview.acm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用三个线程，1个线程打印X，1个线程打印Y，1个线程打印Z，同时执行连续打印10次XYZ
 */
public class PrintXYZ1 {

    static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (count.get() == 1) {
                        System.out.print("x");
                        count.getAndSet(2);
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (count.get() == 2) {
                        System.out.print("y");
                        count.getAndSet(3);
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (count.get() == 3) {
                        System.out.print("z");
                        count.getAndSet(1);
                        System.out.println("");
                    }
                }
            }).start();
        }
    }
}
