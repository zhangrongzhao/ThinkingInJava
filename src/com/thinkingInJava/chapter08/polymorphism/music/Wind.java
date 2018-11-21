package com.thinkingInJava.chapter08.polymorphism.music;
//because they have the same interface.
public class Wind extends Instrument {
    //Redefine interface method.
    public void  play(Note n){
        System.out.println("Wind.play() "+n);
    }
}
