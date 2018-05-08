package com.thinkingInJava.chapter11.holding;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args){
        LinkedList<Integer> intList = new LinkedList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8));

        System.out.println(intList.offer(0));
        System.out.println(intList);
    }
}
