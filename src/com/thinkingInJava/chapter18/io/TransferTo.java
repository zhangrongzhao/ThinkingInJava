package com.thinkingInJava.chapter18.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

//Using transferTo() between channels.
public class TransferTo {
    public static void main(String[] args)throws Exception{
        if(args.length!=2){
            System.out.println("arguments:sourceFile destFile");
            System.exit(1);
        }
        FileChannel in=new FileInputStream(args[0]).getChannel();
        FileChannel out=new FileOutputStream(args[1]).getChannel();
        in.transferTo(0,in.size(),out);
        //Or:
        //out.transferFrom(in,0,in.size());
    }
}
