package com.thinkingInJava.chapter18.io;

import com.thinkingInJava.util.Directory;
import com.thinkingInJava.util.PPrint;

import java.io.File;

//Simple use  of Directory utilities.
public class DirectoryDemo {
    public static void main(String[] args){
        //All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        //All files beginning with 'T'
        for(File file:Directory.local(".","T.*")){
            System.out.println(file);
        }
        System.out.println("--------------------------------------");
        //All java file beginning with 'T'
        for(File file:Directory.walk(".","T.*\\.java")){
            System.out.println(file);
        }
        System.out.println("--------------------------------------");
        //Class files containing "Z" or "z"
        for(File file:Directory.walk(".",".*[Zz].*\\.class")){
            System.out.println(file);
        }
    }
}
