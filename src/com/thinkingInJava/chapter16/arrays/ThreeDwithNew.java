package com.thinkingInJava.chapter16.arrays;

import java.util.Arrays;

public class ThreeDwithNew {
    public static void main(String[] args){
        //3-d array with fixed length
        int[][][] a=new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
}
