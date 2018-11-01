package com.thinkingInJava.chapter16.arrays;

import java.util.Arrays;

public class AutoboxingArrays {
    public static void main(String[] args){
        Integer[][] a = {//Autoboxing:
                {1,2,3,4,5,6,7,8,9,10},
                {21,22,23,24,25,26,27,28,29,210},
                {31,32,33,34,35,36,73,38,39,310},
                {41,42,43,44,45,46,47,48,49,410},
        };
        System.out.println(Arrays.deepToString(a));
    }
}
