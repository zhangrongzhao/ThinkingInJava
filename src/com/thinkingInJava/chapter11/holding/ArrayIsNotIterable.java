package com.thinkingInJava.chapter11.holding;

import java.util.Arrays;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib){
        for(T t:ib){
            System.out.println(t+" ");
        }
    }
    public static void main(String[] args){
        test(Arrays.asList(1,2,3));
        String[] strings={"A","B","C"};
        //test(strings);
        test(Arrays.asList(strings));
    }
}
