package com.thinkingInJava.chapter15.generics;

import java.util.Date;

/**
 * Created by rongzhao on 2018/6/17.
 */

interface TimeStamped{ long getStamp(); }
class TimeStampedImp implements TimeStamped{
    private final long timeStamp;
    public TimeStampedImp(){
        timeStamp=new Date().getTime();
    }
    public long getStamp(){return timeStamp;}
}

interface SerialNumbered{long getSerialNumber();}
class SerialNumberedImp implements SerialNumbered{
    private static long counter=1;
    private final long serialNumber=counter++;
    public long getSerialNumber(){return serialNumber;}
}

interface Basic {
    public void set(String val);
    public String get();
}
class BasicImp implements Basic{
    private String value;
    public void set(String val){this.value=val;}
    public String get(){return value;}
}

class Mixin extends BasicImp implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamp=new TimeStampedImp();
    private SerialNumbered serialNubmer=new SerialNumberedImp();
    public long getStamp(){return timeStamp.getStamp();}
    public long getSerialNumber(){return serialNubmer.getSerialNumber();}
}
public class Mixins {
    public static void main(String[] args){
        Mixin mixin1=new Mixin(),mixin2=new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get()+" "+mixin1.getStamp()+" "+mixin2.getSerialNumber() );
        System.out.println(mixin2.get()+" "+mixin2.getStamp()+" "+mixin2.getSerialNumber());
    }
}

//缺点：复杂混型，代码数量急速增加
