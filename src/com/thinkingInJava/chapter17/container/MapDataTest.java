package com.thinkingInJava.chapter17.container;

import com.thinkingInJava.util.Generator;
import com.thinkingInJava.util.MapData;
import com.thinkingInJava.util.Pair;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size=9;
    private int number=1;
    private char letter='A';
    public Pair<Integer,String> next(){
        return new Pair<Integer, String>(number++,""+letter++);
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number<size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}


public class MapDataTest {
    public static void main(String[] args){
        //Pair Generator:
        System.out.println(MapData.map(new Letters(),11));
        //Two separate generators
        //System.out.println(MapData.map(new CountingGenerator.Character(),new RandomGenerator.String(3),8));
        //A key generator and a single value
        //System.out.println(MapData.map(new CountingGenerator.Character(),"Value",6));
        //An iterable and a value Generator
        //System.out.println(MapData.map(new Letters(),new RandomGenerator.String(3)));
        System.out.println(MapData.map(new Letters(),"pop"));
    }

}
