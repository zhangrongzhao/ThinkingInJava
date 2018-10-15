package com.thinkingInJava.chapter19.enumerated;
//The withches in the land of Oz.
public enum OzWitch {
    //Instances must be defined first,before methods:
    WEST("Miss Gulch,aka the Wiched Witch of the West"),
    NORTH("Glinda,the good Witch of the North"),
    EAST("Wicked Witch of the East,wearer of the Ruby Slippers,crushed by Dorothy's house"),
    SOUTH("Good by inference,but missing");
    private String description;
    private OzWitch(String description){
        this.description=description;
    }
    public String getDescription(){return this.description;}
    public static void main(String[] args){
        for(OzWitch witch:OzWitch.values()){
            System.out.println(witch+":"+witch.getDescription());
        }
    }
}
