package com.thinkingInJava.chapter09.music4;

public class Stringed extends Instrument {
    public void play(Note n){
        System.out.println("Stringed.play() "+n);
    }
    public String what(){return "Stringed";}
    public void adjust(){ }
}
