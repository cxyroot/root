package com.google.test2;

/**
 * 描述：
 * <p>
 * author caoxiaoyang
 * date 2023-02-19
 * version
 */

import java.util.Scanner;

public class ThreadDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        sc.next();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                }
            }
        }, "true").start();
        testWait(new Object());
    }

    public static void testWait(Object obj) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "wait").start();
    }
}
