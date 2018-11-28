package com.thinkingInJava.chapter09.music4;
//Abstract classes and methods.
public class Music4 {
    //Doesn't care about type,so new types added to the system still work right.
    static void tune(Instrument i){i.play(Note.MIDDLE_C);}
    static void tuneAll(Instrument[] e){
        for(Instrument i:e){
            tune(i);
        }
    }
    public static void main(String[] args){
        //Upcasting during addition to the array.
        Instrument[] orchestra={new Wind(),new Percussion(),new Stringed(),new Brass(),new Woodwind()};
        tuneAll(orchestra);
    }
}
