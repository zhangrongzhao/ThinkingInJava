package com.thinkingInJava.chapter09.music5;

//because they have the same interface.
public class Wind implements Instrument {
    //Redefine interface method.
    public void  play(Note n){
        System.out.println(this+".play() "+n);
    }
    public String toString(){return "Wind";}
    public void adjust(){System.out.println(this+".adjust()");}
}
