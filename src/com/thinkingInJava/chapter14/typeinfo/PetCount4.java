package com.thinkingInJava.chapter14.typeinfo;

import com.thinkingInJava.chapter14.typeinfo.pets.Pet;
import com.thinkingInJava.chapter14.typeinfo.pets.Pets;
import com.thinkingInJava.util.TypeCounter;

public class PetCount4 {
    public static void main(String[] args){
        TypeCounter counter=new TypeCounter(Pet.class);
        for(Pet pet:Pets.createArray(20)){
            System.out.println(pet.getClass().getSimpleName()+" ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
