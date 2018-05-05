package com.thinkingInJava.chapter10.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongzhao on 2018/5/5.
 */
public class Controller {
    private List<Event>  eventList=new ArrayList<Event>();
    public void addEvent(Event c){eventList.add(c);}
    public void run(){
        while(eventList.size()>0){
            for(Event e:new ArrayList<Event>(eventList)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
