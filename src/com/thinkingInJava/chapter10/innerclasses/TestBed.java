package com.thinkingInJava.chapter10.innerclasses;

/**
 * Created by rongzhao on 2018/5/3.
 */
public class TestBed {
    public void f(){System.out.println("f();");}
    public static class Tester{
        public static void main(String[] args){
            TestBed t=new TestBed();
            t.f();
        }
    }
}
