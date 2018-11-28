package com.thinkingInJava.chapter09.music4;

public class Percussion extends Instrument {
    public void play(Note n){
        System.out.println("Percussion.play() "+n);
    }
    public String what(){return "Percussion";}
    public void adjust(){ }
}
