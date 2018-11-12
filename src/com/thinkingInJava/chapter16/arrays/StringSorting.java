package com.thinkingInJava.chapter16.arrays;

import com.thinkingInJava.util.Generated;
import com.thinkingInJava.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

//Sorting an array of Strings
public class StringSorting {
    public static void main(String[] args){
        String[] sa=Generated.array(new String[20],new RandomGenerator.String(5));
        System.out.println("Before sort:"+ Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("After sort:"+Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println("Reverse sort: "+Arrays.toString(sa));
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort:"+Arrays.toString(sa));
    }
}
