package com.jingyougroup.service.impl;

import com.jingyougroup.service.BaseService;

public class Person implements BaseService {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void wc() {
        System.out.println("上厕所");
    }
}
