package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static com.thinkingInJava.util.Tuple.tuple;

/**
 * Created by rongzhao on 2018/6/17.
 */

class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object,Class<?>>... pairs){
        delegatesByMethod=new HashMap<String,Object>();
        for(TwoTuple<Object,Class<?>> pair:pairs){
            for(Method method:pair.second.getMethods()){
                String methodName=method.getName();
                if(!delegatesByMethod.containsKey(methodName)){
                    delegatesByMethod.put(methodName,pair.first);
                }
            }
        }
    }
    public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
        String methodName=method.getName();
        Object delegate=delegatesByMethod.get(methodName);
        return method.invoke(delegate,args);
    }

    public static Object newInstance(TwoTuple... pairs){
        Class[] interfaces=new Class[pairs.length];
        for(int i=0;i< pairs.length;i++){
            interfaces[i]=(Class)pairs[i].second;
        }
        ClassLoader c1=pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(c1,interfaces,new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String[] args){
        Object mixin=MixinProxy.newInstance(
                tuple(new BasicImp(),Basic.class),
                tuple(new TimeStampedImp(),TimeStamped.class),
                tuple(new SerialNumberedImp(),SerialNumbered.class));

        Basic b=(Basic)mixin;
        TimeStamped t=(TimeStamped)mixin;
        SerialNumbered s=(SerialNumbered)mixin;
        b.set("hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
