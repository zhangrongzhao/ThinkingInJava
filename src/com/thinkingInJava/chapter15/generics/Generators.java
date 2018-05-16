package com.thinkingInJava.chapter15.generics;

import com.thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,int n){
        for(int i=0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }

    static class IntegerGenerator implements Generator<Integer>{
        private Random rand=new Random(47);
        public Integer next(){
              return rand.nextInt(100);
        }
    }

    public static void main(String[] args){
        Collection<Integer> nCollection = fill(new ArrayList<Integer>(),new IntegerGenerator(),100 );
        for(Integer n:nCollection){
            System.out.print(n+" ");
        }
        System.out.println();
        Collection<Integer> fnumbers=fill(new ArrayList<Integer>(),new Fibonacci(),12);
        for(int i:fnumbers){
            System.out.print(i+",");
        }
    }
}
