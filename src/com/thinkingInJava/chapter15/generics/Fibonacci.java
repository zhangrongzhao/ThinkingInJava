package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.Generator;

//基本类型无法作为类型参数
public class Fibonacci implements Generator<Integer> {
    private int count=0;
    public Integer next(){return fib(count++);}//自动装箱和拆箱的功能
    private int fib(int n){
        if(n<2) return 1;
        return fib(n-2)+fib(n-1);
    }
    public static void main(String[] args){
        Fibonacci gen=new Fibonacci();
        for(int i=0;i<18;i++){
            System.out.print(gen.next() + " ");
        }
    }
}
