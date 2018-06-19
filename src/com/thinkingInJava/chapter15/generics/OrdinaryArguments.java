package com.thinkingInJava.chapter15.generics;

/**
 * Created by rongzhao on 2018/6/16.
 */

class OrdinarySetter{
    void set(Base base){
        System.out.println("OridnarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter{
    void set(Derived derived){
        System.out.println("DerivedSetter.set(Derived)");
    }
}

public class OrdinaryArguments {
    public static void main(String[] args){
        Base base=new Base();
        Derived derived=new Derived();
        DerivedSetter ds=new DerivedSetter();
        ds.set(derived);
        ds.set(base);
    }
}
