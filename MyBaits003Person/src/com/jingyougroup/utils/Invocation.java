package com.jingyougroup.utils;

import com.jingyougroup.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invocation implements InvocationHandler{

    private BaseService obj;
    public Invocation(BaseService params) {
        this.obj=params;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        Object value=null;
        String methodName=method.getName();
        if (methodName.equals("eat")){
            wash();
            value = method.invoke(this.obj,params);
        }else{

        }
        return value;
    }
    //
    public void wash(){
        System.out.println("--------洗手--------");
    }
}
