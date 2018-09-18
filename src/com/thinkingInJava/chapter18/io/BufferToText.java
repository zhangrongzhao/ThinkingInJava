package com.thinkingInJava.chapter18.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

//Converting text to and from  ByteBuffers.
public class BufferToText {
    private static final int BSIZE=1024;
    public static void main(String[] args)throws Exception{
        //Write a file
        FileChannel fc=new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        //Read the file:
        fc=new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        //Doesn't work:
        System.out.println(buff.asCharBuffer());
        //Decode using this system's default Charset:
        buff.rewind();
        String encoding=System.getProperty("file.encoding");
        System.out.println("Decoded using "+encoding+": "+ Charset.forName(encoding).decode(buff));
        //Or,We could encode with something that will print:
        fc=new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        //Now try reading again:
        fc=new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        //Use a CharBuffer to write through:
        fc=new FileOutputStream("data2.txt").getChannel();
        buff=ByteBuffer.allocate(24);//More than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        //Read and display:
        fc=new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
