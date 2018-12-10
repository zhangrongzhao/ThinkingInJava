package com.thinkingInJava.chapter06.access;

import com.thinkingInJava.chapter06.access.dessert.Cookie;

//can not use package-access member from another package
public class ChocolateChip extends Cookie {
    public ChocolateChip(){
        System.out.println("ChocolateChip constructor");
    }
    public void chomp(){
        //bite(); Can not access bite
    }
    public static void main(String[] args){
        ChocolateChip x=new ChocolateChip();
        x.chomp();
    }
}
