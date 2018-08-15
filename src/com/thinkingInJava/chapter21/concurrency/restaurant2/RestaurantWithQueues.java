package com.thinkingInJava.chapter21.concurrency.restaurant2;

import com.thinkingInJava.chapter21.concurrency.Restaurant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

//This is given to the waiter,who gives it to the chef:
class Order{//(A data-transfer object)
    private static int counter=0;
    private final int id=counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final final Food food;
    public Order(Customer cust,WaitPerson wp.Food t){
        this.customer=cust;
        this.waitPerson=wp;
        this.food=f;
    }
    public Food item(){return this.food;}
    public Customer getCustomer(){return this.customer;}

    public WaitPerson getWaitPerson() {
         return this.waitPerson;
    }
    public String toString(){
        return "Order:" + id + " item: " + food + " for: "+customer+" served by: " + waitPerson;
    }
}
//This is what comes back from the chef:
class Plate{
    private final Order order;
    private final Food food;
    public Plate(Order ord,Food f){
        this.order=ord;
        this.food=f;
    }
    public Order getOrder(){return this.order;}
    public Food getFood(){return this.food;}
    public String toString(){return this.food.toString();}
}

class Customer implements Runnable{
    private static int counter=0;
    private final int id=counter++;
    private final WaitPerson waitPerson;
    //Only one course at a time can be received
    private SynchronousQueue<Plate> placeSetting=new SynchronousQueue<Plate>();
    public Customer(WaitPerson w){this.waitPerson=w;}
    public void deliver(Plate p)throws InterruptedException{
        //Only blocks if customer is still eating the previous course
        placeSetting.put(p);
    }
    public void run(){
        for(Course course:Course.values()){
            Food food=course.randdomSelection();
            try{
                waitPerson.placeOrder(this,food);
                //Blocks until course has been delivered:
                System.out.println(this+" eating "+placeSetting.take());
            }catch(InterruptedException e){
                System.out.println(this+" waiting for "+course+" interrupted");
                break;
            }
        }
        System.out.println(this+" finished meal,leaving ");
    }
    public String toString(){
        return "Customer "+id+" ";
    }
}

class WaitPerson implements Runnable{
    private static int counter=0;
    private final int id=counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();
    public WaitPerson(Restaurant rest){this.restaurant=rest;}
    public void placeOrder(Customer cust,Food food){
        try{
            //Shouldn't actually block because this is a linkedBlockQueue with no size limit:
            restaurant.orders.put(new Order);
        }catch(InterruptedException e){
            System.out.println(this + " placeOrder interrupted");
        }
    }
}

public class RestaurantWithQueues {
}
