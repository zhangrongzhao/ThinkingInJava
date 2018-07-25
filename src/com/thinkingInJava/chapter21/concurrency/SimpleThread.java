package com.thinkingInJava.chapter21.concurrency;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleTypeHost;

//Inheriting directly form the Thread class
public class SimpleThread  extends Thread{
    private int countDown=5;
    private static int threadCount=0;
    public SimpleThread(){
        //Store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#"+getName()+"("+countDown+"),";
    }

    public void run(){
        while(true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new SimpleThread();
        }
    }
}
