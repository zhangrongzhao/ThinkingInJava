package com.thinkingInJava.chapter19.enumerated;
//enum NotPossible extends Pet { }

//An enum can implement in interface


import com.thinkingInJava.util.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SALPPY,SPANKY,PUNCHY,LILLY,BOUNCY,NUTTY,BOB;
    private Random rand=new Random(47);
    public CartoonCharacter next(){
        return values()[rand.nextInt(values().length)];
    }
}


public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg){
        System.out.print(rg.next()+", ");
    }
    public static void main(String[] args){
        //Choose any instance
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0;i<10;i++){
            printNext(cc);
        }
    }
}
