package com.thinkingInJava.chapter11.holding;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rongzhao on 2018/5/7.
 */
public class SimpleIteration {
    public static void main(String[] args){
        List<Integer> ints= Arrays.asList(1,2,3,4);
        ListIterator<Integer> iterator=ints.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }

        for(Integer p:ints){
            System.out.println(p);
        }

        Iterator<Integer> it=ints.iterator();
        for(int i=0;i<6;i++){
            it.next();
            it.remove();
        }
    }
}
