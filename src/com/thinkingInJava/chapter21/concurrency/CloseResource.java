package com.thinkingInJava.chapter21.concurrency;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost",8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing "+socketInput.getClass().getName());
        socketInput.close();//Released blocked thread
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing "+System.in.getClass().getName());
        System.in.close();//Releases blocked thread
    }
}

//不能直接中断IO线程。方案：关闭在任务上发生阻塞的底层资源。
