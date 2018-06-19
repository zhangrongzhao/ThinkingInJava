package com.thinkingInJava.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by rongzhao on 2018/6/17.
 */

class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector(Object proxied){
        this.proxied=proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        if(method.getName().equals("interesting")){
            System.out.println("Proxy detected the interesting method");
        }
        return method.invoke(proxied,args);
    }
}

interface SomeMethods{
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods{
    public void boring1(){System.out.println("boring1");}
    public void boring2(){System.out.println("boring2");}
    public void interesting(String arg){System.out.println("Interesting "+arg);}
    public void boring3(){System.out.println("boring2");}
}

public class SelectingMethods {
    public static void main(String[] args){
        SomeMethods proxy=(SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation())
        );
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting("bonobo");
    }
}
