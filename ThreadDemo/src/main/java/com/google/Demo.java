package com.google;

import java.beans.Introspector;

public class Demo {
    public static void main(String[] args) {
        String springCaoXiaoYang = Introspector.decapitalize("SpringCaoXiaoYang");
        System.out.println(springCaoXiaoYang);
    }
}
