package com.google.test2;

/**
 *
 * -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -XX:PretenureSizeThreshold=6M
 * @author CAOXIAOYANG
 *	逃逸分析：分析对象的作用域
 *
 */
public class OldMain {
    public static void main(String[] args) {
        byte[] b1 = new byte[200 * 1024 * 1024];
    }
}
