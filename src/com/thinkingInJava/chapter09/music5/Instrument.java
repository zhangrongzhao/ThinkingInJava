package com.thinkingInJava.chapter09.music5;

public interface Instrument {
    //Compile-time constant
    int VALUE = 5;//static & final
    //Cannot have method definitions.
    void play(Note n);//Automatically public
    void adjust();
}
