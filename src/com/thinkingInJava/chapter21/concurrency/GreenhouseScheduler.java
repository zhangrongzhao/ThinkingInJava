package com.thinkingInJava.chapter21.concurrency;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//Rewriting innerclasses/GreenhouseController.java
//to use a ScheduleedThreadPoolExecutor
//{Args:5000}
public class GreenhouseScheduler {
    private volatile boolean light=false;
    private volatile boolean water=false;
    private String thermostat = "Day";
    public synchronized String getThermostat(){return this.thermostat;}
    public synchronized void setThermostat(String value){this.thermostat=value;}
    ScheduledThreadPoolExecutor scheduler=new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event,long delay){
        scheduler.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event,long initialDelay,long period){
        scheduler.scheduleAtFixedRate(event,initialDelay,period,TimeUnit.MILLISECONDS);
    }
    class LightOn implements Runnable{
        public void run(){
            //Put hardware control code here to physically turn on the light.
            System.out.println("Turn on the lights");
            light=true;
        }
    }
    class LightOff implements Runnable{
        public void run(){
            //Put hardware control code here to physically turn off the light.
            System.out.println("Turning off lights");
            light=false;
        }
    }
    class WaterOn implements Runnable{
        public void run(){
            System.out.println("Turn greenhouse water on");
            water=true;
        }
    }
    class WaterOff implements Runnable{
        public void run(){
            System.out.println("Turn greenhouse water off");
            water=false;
        }
    }
    class ThermostatNight implements Runnable{
        public void run(){
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }
    class ThermostatDay implements Runnable{
        public void run(){
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }
    class Bell implements Runnable{
        public void run(){
            System.out.println("Bing!");
        }
    }
    class Terminate implements Runnable{
        public void run(){
            System.out.println("Terminating");
            scheduler.shutdownNow();
            //Must start a separate task to do this job,
            //since the scheduler has been shut down.
            new Thread(){
                public void run(){
                    for(DataPoint d:data){
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }
    //New feature:data Collection
    static class DataPoint{
        final Calendar time;
        final float temperature;
        final float humidity;
        public DataPoint(Calendar d,float temp,float hum){
            this.time=d;
            this.temperature=temp;
            this.humidity=hum;
        }
        public String toString(){
            return time.getTime()+String.format(" temperature:%1$.1f humidity:%2$.2f",temperature,humidity);
        }
    }
    private Calendar lastTime=Calendar.getInstance();
    {
        //Adjust date to the half hour
        lastTime.set(Calendar.MINUTE,30);
        lastTime.set(Calendar.SECOND,00);
    }
    private float lastTemp=65.0f;
    private int tempDirection=+1;
    private float lastHumidity=50.0f;
    private int humidityDirection=+1;
    private Random rand=new Random(47);
    List<DataPoint>  data = Collections.synchronizedList(new ArrayList<DataPoint>());
    class CollectData implements Runnable{
        public void run(){
            System.out.println("Collecting Data");
            synchronized (GreenhouseScheduler.this){
                //Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE)+30);
            }
        }
    }
}
