package com.thinkingInJava.chapter16.arrays;

import com.thinkingInJava.util.Generated;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args){
        CompType[] a=Generated.array(new CompType[12],CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
}
