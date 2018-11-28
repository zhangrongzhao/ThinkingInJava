package com.thinkingInJava.chapter09.music4;

public abstract class Instrument {
    private int i;//Storage allocated for each
    public abstract void play(Note n);
    public String what(){return "Instrument";}
    public abstract void adjust();
}
