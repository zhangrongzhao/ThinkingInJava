package com.thinkingInJava.chapter15.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {

    @SuppressWarnings("unchecked")
    public void f(String[] args)throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(""));
        //List<Widget> shapes=(List<Widget>)in.readObject();
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
