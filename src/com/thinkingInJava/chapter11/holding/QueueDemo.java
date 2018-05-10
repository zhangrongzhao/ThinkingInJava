package com.thinkingInJava.chapter11.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by rongzhao on 2018/5/9.
 */
public class QueueDemo {
    public static void printQ(Queue queue){
        while(queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Queue<Integer> queue=new LinkedList<Integer>();
        Random rand=new Random(47);
        for(int i=0;i<10;i++){
            queue.offer(rand.nextInt(i+10));
        }
        System.out.println(queue);
        Queue<Character> qc=new LinkedList<Character>();
        for(char c:"Brontosaurus".toCharArray()){
            qc.offer(c);
        }
        System.out.println(qc);
        qc.peek();//查询队头元素，队列为空时，返回null
        qc.element();//队列为空时，抛出NoSuchElementException
        qc.poll();//移除返回队头，队列为空时，返回null
        qc.remove();//队列为空时，抛出NoSuchElementException
    }
}
