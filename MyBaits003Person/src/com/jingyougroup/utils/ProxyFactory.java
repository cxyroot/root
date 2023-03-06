package com.jingyougroup.utils;


import com.jingyougroup.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static BaseService Builer(Class classFile){
        try {
            BaseService beanService= (BaseService) classFile.newInstance();
            InvocationHandler invocationHandler = new Invocation(beanService);
            BaseService $proxy = (BaseService) Proxy.newProxyInstance(beanService.getClass().getClassLoader(),beanService.getClass().getInterfaces(),invocationHandler);
            return $proxy;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
