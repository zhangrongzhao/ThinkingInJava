package com.thinkingInJava.chapter21.concurrency;
//A complex example of tasks working together.

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

class Car{
    private final int id;
    private boolean engine=false,driveTrain=false,wheels=false;
    public Car(int idn){this.id=idn;}
    //Empty car object;
    public Car(){this.id=-1;}
    public synchronized int getId(){ return this.id;}
    public synchronized void addEngine(){this.engine=true;}
    public synchronized void addDriveTrain(){this.driveTrain=true;}
    public synchronized void addWheels(){this.wheels=true;}
    public synchronized String toString(){
        return "Car " + id + " ["+" engine: " + this.engine + " driveTrain: "+driveTrain+" wheels: " + wheels + "]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car> {}

class ChassisBuilder implements Runnable{//底盘
    private CarQueue carQueue;
    private int counter=0;
    public ChassisBuilder(CarQueue cq){this.carQueue=cq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                //Make chassis
                Car c=new Car(counter++);
                System.out.println("ChassisBuilder created "+c);
                //Insert into queue
                carQueue.put(c);
            }
        }catch(InterruptedException e){
            System.out.println("Interrupted:ChassisBuilder");
        }
    }
}

class Assembler implements Runnable{
    private CarQueue chassisQueue,finishQueue;
    private Car car;
    private CyclicBarrier barrier=new CyclicBarrier(4);
    private RobotPool robotPool;
    public Assembler(CarQueue cq,CarQueue fq,RobotPool rp){
        this.chassisQueue=cq;
        this.finishQueue=fq;
        this.robotPool=rp;
    }
    public Car car(){return car;}
    public CyclicBarrier barrier(){return barrier;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                //Blocks until chassis is available
                car=chassisQueue.take();
                //Hire robots to perform work:
                robotPool.hire(EngineRobot.class,this);
                robotPool.hire(DriveTrainRobot.class,this);
                robotPool.hire(WheelRobot.class,this);
                barrier.await();//Until the robots finish
                //Put car into finishingQueue for further work
                finishQueue.put(car);
            }
        }catch(InterruptedException e){
            System.out.println("Exiting Assembler via interrupt");
        }catch(BrokenBarrierException e){
            //This one we ant to know about
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}

class Reporter implements Runnable{
    private CarQueue carQueue;
    public Reporter(CarQueue cq){this.carQueue=cq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                System.out.println(carQueue.take());
            }
        }catch(InterruptedException e){
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}

abstract  class Robot implements Runnable{
    private RobotPool pool;
    public Robot(RobotPool p){this.pool=p;}
    protected Assembler assembler;
    public Robot assignAssembler(Assembler assembler){
        this.assembler=assembler;
        return this;
    }
    private boolean engage=false;//是否被聘用
    public synchronized void engage(){
        this.engage=false;
        notifyAll();
    }
    //The part of run() that's different for each robot:
    abstract protected  void performService();
    public void run(){
        try{
            while(!Thread.interrupted()){
                performService();
                assembler.barrier().await();//Synchronize
                //We're done with that job..
                powerDown();
            }
        }catch(InterruptedException e){
            System.out.println("Exiting "+this+" via interrupt");
        }catch(BrokenBarrierException e){
            //This one we ant to know about
            throw new RuntimeException(e);
        }
    }
    private synchronized void powerDown()throws InterruptedException{
        this.engage=false;
        assembler=null;//Disconnect from the Assembler
        //put ourselves back in the available pool:
        pool.release(this);
        while(this.engage==false){//Power down
           wait();
        }
    }
    public String toString(){return getClass().getName();}
}

class EngineRobot extends Robot{
    public EngineRobot(RobotPool pool){super(pool);}
    protected void performService(){
        System.out.println(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot{
    public DriveTrainRobot(RobotPool pool){super(pool);}
    protected void performService(){
        System.out.println(this + " installing driveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot{
    public WheelRobot(RobotPool pool){super(pool);}
    protected void performService(){
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class RobotPool{
    //Quietly prevents identical entries:
    private Set<Robot> pool=new HashSet<Robot>();
    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }
    public synchronized void hire(Class<? extends Robot> robotType,Assembler d)throws InterruptedException{
        for(Robot r:pool){
            if(r.getClass().equals(robotType)){
                pool.remove(r);
                r.assignAssembler(d);
                r.engage();//Power it up to do the task
                return;
            }
        }
        wait();//None available
        hire(robotType,d);//Try again,recursively
    }
    public synchronized void release(Robot r){add(r);}
}

public class CarBuilder {
    public static void main(String[] args)throws Exception{
        CarQueue chassisQueue = new CarQueue(),finishedQueue = new CarQueue();
        ExecutorService exec=Executors.newCachedThreadPool();
        RobotPool robotPool=new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue,finishedQueue,robotPool));
        exec.execute(new Reporter(finishedQueue));
        //Start everything running by producing chassis:
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}