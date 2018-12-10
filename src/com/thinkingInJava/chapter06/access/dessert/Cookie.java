package com.thinkingInJava.chapter06.access.dessert;

public class Cookie {
    public Cookie(){
        System.out.println("Dinner constructor");
    }
    void bite(){//仅具有包访问权限
        System.out.println("bite");
    }
}
