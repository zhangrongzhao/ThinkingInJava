package com.thinkingInJava.chapter10.innerclasses.Greenhouse;

import com.thinkingInJava.chapter10.innerclasses.controller.Controller;
import com.thinkingInJava.chapter10.innerclasses.controller.Event;

/**
 * Created by rongzhao on 2018/5/5.
 */
public class GreenhouseControls extends Controller {
    private boolean light=false;
    public class LightOn extends Event {
        public LightOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            light=true;
        }
        public String toString(){return "Light is on";}
    }
    public class LightOff extends Event{
        public LightOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            light=false;
        }
        public String toString(){
            return "Light is off";
        }
    }

    private boolean water=false;
    public class WaterOn extends Event{
        public WaterOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            water=true;
        }
        public String toString(){
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            water=false;
        }
        public String toString(){
            return "Greenhouse water is off";
        }
    }

    private String thermostat="Day";
    public class ThemostatNight extends Event{
        public ThemostatNight(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat="Night";
        }
        public String toString(){
            return "Thermostat on night setting";
        }
    }
    public class ThemostatDay extends Event{
        public ThemostatDay(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat="Day";
        }
        public String toString(){
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event{
        public Bell(long delayTime){super(delayTime);}
        public void action(){
            addEvent(new Bell(delayTime));
        }
        public String toString(){return "Bing!";}
    }

    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime,Event[] eventList){
            super(delayTime);
            this.eventList=eventList;
            for(Event e:eventList){
                addEvent(e);
            }
        }
        public void action(){
            for(Event e:eventList){
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }
        public String toString(){
            return "Restarting System";
        }
    }
    public static class Terminate extends Event{
        public Terminate(long delayTime){super(delayTime);}
        public void action(){System.exit(0);}
        public String toString(){return "Terminating";}
    }
}
