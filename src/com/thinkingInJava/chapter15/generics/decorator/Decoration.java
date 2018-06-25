package com.thinkingInJava.chapter15.generics.decorator;

import java.util.Date;

/**
 * Created by rongzhao on 2018/6/17.
 */

class Basic{
    private String value;
    public void set(String val){this.value=val;}
    public String get(){return value;}
}

class Decorator extends Basic{
    protected Basic basic;
    public Decorator(Basic basic){this.basic=basic;}
    public void set(String val){basic.set(val);}
    public String get(){return basic.get();}
}

class TimeStamped extends Decorator{
    private final long timeStamp;
    public TimeStamped(Basic basic){
        super(basic);
        timeStamp=new Date().getTime();
    }
    public long getStamp(){return timeStamp;}
}

class SerialNumbered extends Decorator{
    private static long counter=1;
    private final long serialNumber=counter++;
    public SerialNumbered(Basic basic){
        super(basic);
    }
    public long getSerialNumber(){return serialNumber;}
}

public class Decoration {
    public static void main(String[] args){
        TimeStamped t=new TimeStamped(new Basic());
        TimeStamped t2=new TimeStamped(new SerialNumbered(new Basic()));
        SerialNumbered s=new SerialNumbered(new Basic());
        SerialNumbered s2=new SerialNumbered(new TimeStamped(new Basic()));
    }
}
