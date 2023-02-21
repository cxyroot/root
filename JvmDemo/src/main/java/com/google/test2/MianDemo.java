package com.google.test2;

/**
 * 优先到eden区
 * -verbose:gc -XX:+PrintGCDetails
 * -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC
 * 内存分配担保
 * -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * @author CAOXIAOYANG
 */
public class MianDemo {
    public static void main(String[] args) {
        byte[] b1 = new byte[2 * 1024 * 1024];
        byte[] b2 = new byte[2 * 1024 * 1024];
        byte[] b3 = new byte[2 * 1024 * 1024];
        byte[] b4 = new byte[4 * 1024 * 1024];
        System.gc();
    }
}

