package com.thinkingInJava.chapter15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongzhao on 2018/5/15.
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T... args){
        List<T> result=new ArrayList<T>();
        for(T item:args){
            result.add(item);
        }
        return result;
    }
    public static void main(String[] args){
        List<String> ls=makeList("A");
        System.out.print(ls);

        ls=makeList("A","B","C");
        System.out.print(ls);

        ls=makeList("ABCDEFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);

    }
}
