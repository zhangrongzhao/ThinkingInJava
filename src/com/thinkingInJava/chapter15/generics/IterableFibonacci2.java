package com.thinkingInJava.chapter15.generics;

import java.util.Iterator;

public class IterableFibonacci2 implements Iterable<Integer> {
    private int n;
    private Fibonacci fib;
    public IterableFibonacci2(Fibonacci fib,int n){
        this.fib = fib;
        this.n = n;
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci2.this.fib.next();
            }

            @Override
            public void remove() {
               throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        Fibonacci fibonacci=new Fibonacci();
        IterableFibonacci2 fib2=new IterableFibonacci2(fibonacci,18);
        for(int i:fib2){
            System.out.print(i + " ");
        }
    }
}
