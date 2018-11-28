package com.thinkingInJava.chapter09.music4;

//because they have the same interface.
public class Wind extends Instrument {
    //Redefine interface method.
    public void  play(Note n){
        System.out.println("Wind.play() "+n);
    }
    public String what(){return "Wind";}
    public void adjust(){}
}
