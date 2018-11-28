package com.thinkingInJava.chapter09.music5;

public class Stringed implements Instrument {
    public void play(Note n){
        System.out.println(this+".play() ");
    }
    public String toString(){return "Stringed";}
    public void adjust(){ System.out.println(this+".adjust()");}
}
