package com.thinkingInJava.chapter09.interfaces;

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implementation1 implements  Service{
    Implementation1(){ }//Package access
    public void method1(){System.out.println("Implementation1 method1");}
    public void method2(){System.out.println("Implementation1 method2");}
}

class Implementation1Factory implements ServiceFactory{
    Implementation1Factory(){}//Package access
    public Service getService(){return new Implementation1();}
}

class Implementation2 implements  Service{
    Implementation2(){ }//Package access
    public void method1(){System.out.println("Implementation2 method1");}
    public void method2(){System.out.println("Implementation2 method2");}
}

class Implementation2Factory implements ServiceFactory{
    Implementation2Factory(){}//Package access
    public Service getService(){return new Implementation2();}
}

public class Factories {
    public static void ServiceConsumer(ServiceFactory fact){
        Service s=fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        ServiceConsumer(new Implementation1Factory());
        ServiceConsumer(new Implementation2Factory());
    }
}
