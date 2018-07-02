package com.thinkingInJava.chapter14.typeinfo;
public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle,Person employee){
        this.title=jobTitle;
        this.person=employee;
        if(this.person==null){
            this.person=Person.NULL;
        }
    }
    public Position(String jobTitle){
        this.title=jobTitle;
        this.person=Person.NULL;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setPerson(Person person) {
        this.person = person;
        if(this.person==null){
            this.person=Person.NULL;
        }
    }
    public Person getPerson() {
        return person;
    }

    public String toString(){
        return "Position: " + title + " " + person;
    }
}
