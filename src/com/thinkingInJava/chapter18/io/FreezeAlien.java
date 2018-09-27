package com.thinkingInJava.chapter18.io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//Create a serialized output file.
public class FreezeAlien {
    public static void main(String[] args)throws Exception{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek=new Alien();
        out.writeObject(quellek);
    }
}
