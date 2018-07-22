package com.thinkingInJava.util;

/**
 * Created by rongzhao on 2018/7/22.
 */
public class CountingGenerator {
    public static class Integer implements Generator<java.lang.Integer>{
        private int value=0;
        public java.lang.Integer next(){return value++;}
    }
}
