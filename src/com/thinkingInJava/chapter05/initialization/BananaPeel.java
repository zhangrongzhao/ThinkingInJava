package com.thinkingInJava.chapter05.initialization;

class Banana{
    void peel(int i){}
}

public class BananaPeel {
    public static void main(String[] args){
        Banana a=new Banana();
        Banana b=new Banana();
        a.peel(1);
        b.peel(2);
    }
}
