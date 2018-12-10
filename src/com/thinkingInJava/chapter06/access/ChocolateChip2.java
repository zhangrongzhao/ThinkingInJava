package com.thinkingInJava.chapter06.access;

import com.thinkingInJava.chapter06.access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
    public ChocolateChip2(){
        System.out.println("ChocloateChip2 constructor");
    }
    public void chomp(){
       bite();//Protected method
    }
    public static void main(String[] args){
        ChocolateChip2 x=new ChocolateChip2();
        x.chomp();
    }
}
