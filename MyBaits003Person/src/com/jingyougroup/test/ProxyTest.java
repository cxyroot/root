package com.jingyougroup.test;

import com.jingyougroup.service.BaseService;
import com.jingyougroup.service.impl.Person;
import com.jingyougroup.utils.ProxyFactory;

public class ProxyTest {
    public static void main(String[] args) {
        BaseService mike=ProxyFactory.Builer(Person.class);
        mike.eat();
    }
}
