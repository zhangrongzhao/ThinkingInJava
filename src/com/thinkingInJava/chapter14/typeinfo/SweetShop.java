package com.thinkingInJava.chapter14.typeinfo;

class Candy{
    static { System.out.println("Loading Candy"); }
}

class Gum{
    static { System.out.println("Loading Gum"); }
}

class Cookie{
    static { System.out.println("Loading Dinner"); }
}

public class SweetShop {
    public static void main(String[] args){
        new Candy();
        try{
            Class.forName("com.thinkingInJava.chapter14.typeinfo.Gum");
        }catch(ClassNotFoundException e){
            System.out.println("Couldn't find Gum");
        }
        new Cookie();
    }
}
