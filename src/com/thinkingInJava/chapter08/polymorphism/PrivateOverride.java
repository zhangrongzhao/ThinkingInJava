package com.thinkingInJava.chapter08.polymorphism;
//Trying to override a private method.
public class PrivateOverride {
    private void f(){System.out.println("priavte f()");}
    public static void main(String[] args){
        PrivateOverride po=new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){System.out.println("public f()");}
}
