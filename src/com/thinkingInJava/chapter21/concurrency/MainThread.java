package com.thinkingInJava.chapter21.concurrency;

public class MainThread {
    public static void main(String[] args){
        LiftOff launch=new LiftOff();
        launch.run();
    }
}
