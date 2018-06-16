package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/6/16.
 */
class GenericSetter<T>{
    void set(T arg){
        System.out.println("GenericSetter.set(base)");
    }
}
class DerivedGS extends GenericSetter<Base>{
     void set(Derived derived){
        System.out.println("DrivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args){
        Base base=new Base();
        Derived derived=new Derived();
        DerivedGS dgs=new DerivedGS();
        dgs.set(derived);
        dgs.set(base);
    }
}
