package com.thinkingInJava.chapter11.holding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class ForEachCollections {
    public static void main(String[] args){
        Collection<String> cs=new LinkedList<String>();
        Collections.addAll(cs,"Take the long way home".split(" "));
        for(String s:cs){
            System.out.println("'"+s+"'");
        }
    }
}
