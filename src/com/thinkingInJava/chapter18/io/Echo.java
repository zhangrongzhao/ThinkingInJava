package com.thinkingInJava.chapter18.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//How to read form standard input.
public class Echo {
    public static void main(String[] args)throws Exception{
        BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=stdIn.readLine())!=null&&s.length()!=0){
            System.out.println(s);
        }
        //An empty line or Ctrl-z  terminates the program.
    }
}
