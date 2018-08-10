package com.thinkingInJava.chapter21.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

//Using queues and multithreading
//{Args:5}
//Read-only objects don't require synchronization
class Customer{
    private final int serviceTime;
    public Customer(int tm){this.serviceTime=tm;}
    public int getServiceTime(){return this.serviceTime;}
    public String toString(){
        return "["+serviceTime+"]";
    }
}
//Teach the customer line to display itself:
class CustomerLine extends ArrayBlockingQueue<Customer>{
    public CustomerLine(int maxLineSize){
        super(maxLineSize);
    }
    public String toString(){
        if(this.size()==0){
            return "[Empty]";
        }
        StringBuilder result=new StringBuilder();
        for(Customer customer:this){
            result.append(customer);
        }
        return result.toString();
    }
}
//Randomly add customers to a queue:
class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random rand=new Random(47);
    public CustomerGenerator(CustomerLine cq){
        this.customers=cq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }catch (InterruptedException e){
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

public class BankTellerSimulation {
}
