package com.thinkingInJava.chapter14.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types=new ArrayList<Class<? extends Pet>>();
    //Types that you want to be randomly created.
    private static String[] typeNames = {
            "com.thinkingInJava.chapter14.typeinfo.pets.Mutt",
            "com.thinkingInJava.chapter14.typeinfo.pets.Pug",
            "com.thinkingInJava.chapter14.typeinfo.pets.EgyptianMau",
            "com.thinkingInJava.chapter14.typeinfo.pets.Manx",
            "com.thinkingInJava.chapter14.typeinfo.pets.Cymric",
            "com.thinkingInJava.chapter14.typeinfo.pets.Rat",
            "com.thinkingInJava.chapter14.typeinfo.pets.Mouse",
            "com.thinkingInJava.chapter14.typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String name:typeNames){
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    static {
        loader();
    }

    public List<Class<? extends Pet>> types(){ return types;}
}
