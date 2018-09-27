package com.thinkingInJava.chapter18.io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//Demonstrates the "transient keyword"
public class Logon  implements Serializable {
    private Date date=new Date();
    private String userName;
    private transient String password;
    public Logon(String name,String password){
        this.userName=name;
        this.password=password;
    }
    public String toString(){
        return "Logon info:\n username: "+userName+"\n date:"+date+"\n password: "+password;
    }

    public static void main(String[] args)throws Exception{
        Logon a=new Logon("Hulk","myLittlePony");
        System.out.println("Logon a="+a);
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);
        //Now get them back:
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at "+new Date());
        a=(Logon) in.readObject();
        System.out.println("logon a="+a);
    }
}
