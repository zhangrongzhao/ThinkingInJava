package com.thinkingInJava.chapter15.generics;

import java.util.ArrayList;

/**
 * Created by rongzhao on 2018/5/17.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args){
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
    }
}
