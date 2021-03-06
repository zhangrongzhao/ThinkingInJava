package com.thinkingInJava.chapter15.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args){
        //Wildcard allows covariance
        List<? extends Fruit> flist=new ArrayList<Apple>();
        List<? extends Fruit> f1=new ArrayList<Orange>();
        List<? extends Fruit> f2=new ArrayList<Fruit>();
        List<? extends Fruit> f3=new ArrayList<Jonathan>();
        //Compile Error:can't add any type of object:
        //flist.add(new Apple());
        //flist.add(new Fruit());
        //flist.add(new Object());
        flist.add(null);//Legal but uninteresting
        //we know that it returns at least Fruit
        Fruit f=flist.get(0);
    }
}
