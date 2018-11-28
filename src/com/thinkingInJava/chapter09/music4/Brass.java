package com.thinkingInJava.chapter09.music4;

public class Brass extends Instrument {
    public void play(Note n){
        System.out.println("Brass.play() "+n);
    }
    public void adjust(){
        System.out.println("Brass.adjust();");
    }
}
