package com.google;

public class JdkDemo {
    public static void main(String[] args) {
        //模块化系统
        //jshell


        String str = new String();
        str = "123";
        // @Stable
        // private final byte[] value;
        System.out.println(str);
    }

}
/**
 * module Java9 {
 *     //exports
 *     //requires
 * }
 */