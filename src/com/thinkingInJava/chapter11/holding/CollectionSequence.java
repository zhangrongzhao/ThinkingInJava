package com.thinkingInJava.chapter11.holding;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by rongzhao on 2018/5/10.
 */
public class CollectionSequence  extends AbstractCollection<Integer> {
    private Integer[] nArray= new Integer[]{0,1,2,3,4,5,6,7,8,9};
    public int size(){return nArray.length;}
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private int index=0;

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
                return index<nArray.length;
            }

            @Override
            public Integer next() {
                return nArray[index++];
            }
        };
    }

    public static void main(String[] args){
        CollectionSequence c=new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
