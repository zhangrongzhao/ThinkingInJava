package com.thinkingInJava.chapter10.innerclasses.Greenhouse;

import com.thinkingInJava.chapter10.innerclasses.controller.Event;

/**
 * Created by rongzhao on 2018/5/5.
 */
public class GreenhouseController {
    public static void main(String[] args){
        GreenhouseControls gc=new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList={
                gc.new ThemostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThemostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000,eventList));
        //gc.addEvent(new GreenhouseControls.Terminate(new Integer(0)));
        gc.run();
    }
}
