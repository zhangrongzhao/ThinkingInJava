package com.thinkingInJava.chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
    private final int orderNum;
    public Meal(int orderNum){this.orderNum=orderNum;}
    public String toString(){return "Meal "+orderNum;}
}

class WaitPerson implements Runnable{
    private Restaurant restaurant;
    public WaitPerson(Restaurant r){this.restaurant = r;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.meal==null){
                        wait();//...for the chef to produce a meal
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.chef){
                   restaurant.meal = null;
                   restaurant.chef.notifyAll();//Ready for another
                }
            }
        }catch(InterruptedException e){
            System.out.println("WaitPerson interrupted");
        }
    }
}
class Chef  implements Runnable{
    private Restaurant restaurant;
    private int count=0;
    public Chef(Restaurant r){this.restaurant=r;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.meal!=null){
                        wait();//...for the meal to be taken
                    }
                }
                if(++count==10){
                    System.out.println("Out of food,closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order up!");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch(InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }

}

public class Restaurant {
    Meal meal;
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant(){
          exec.execute(chef);
          exec.execute(waitPerson);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
