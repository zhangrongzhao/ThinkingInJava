package com.thinkingInJava.chapter19.enumerated;

public enum OverrideConstantSpecific {
    NUT,BOLT,WASHER{ void f(){System.out.println("Override method");}};
    void f(){System.out.println("Default behavior");}
    public static void main(String[] args){
        for(OverrideConstantSpecific ocs:values()){
            System.out.println(ocs+":");
            ocs.f();
        }
    }
}
