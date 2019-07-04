package edu.pasudo123.app.demo;

public class Person {

    private String name;

    public void setName(String nama){
        this.name = name;
    }

    public void myNameIs(){
        System.out.println(String.format("My Name is {}", name));
    }
}
