package com.thinkingInJava.chapter18.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//Manipulating ints ina ByteBuffer with an IntBuffer.
public class IntBufferDemo {
    private static final int BSIZE=1024;
    public static void main(String[] args){
        ByteBuffer bb=ByteBuffer.allocate(BSIZE);
        IntBuffer ib=bb.asIntBuffer();
        //Store an array of int:
        ib.put(new int[]{11,42,47,99,143,811,1016});
        //Absolute location read and write:
        System.out.println(ib.get(3));
        ib.put(3,1811);
        //Setting a new limit before rewinding the buffer:
        ib.flip();//准备缓冲器，以便提取数据。
        while(ib.hasRemaining()){
            int i=ib.get();
            System.out.println(i);
        }
    }
}
