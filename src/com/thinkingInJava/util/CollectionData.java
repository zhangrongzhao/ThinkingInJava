package com.thinkingInJava.util;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen,int quantity){
        for(int i=0;i<quantity;i++){
            this.add(gen.next());
        }
    }
    //A generic convenience method
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<>(gen,quantity);
    }
}
