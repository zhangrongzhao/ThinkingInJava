package com.thinkingInJava.chapter05.initialization;

//Array initialization
public class DynamicArray {
    public static void main(String[] args){
        Other.main(new String[]{"fiddle","de","dum"});
    }
}
class Other{
    public static void main(String[] args){
        for(String s:args){
            System.out.println(s +" ");
        }
    }
}
