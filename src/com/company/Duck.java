package com.company;

public class Duck extends Animal implements Flying {
    public void Say(){
        System.out.println("Кря");
    }
    public void Fly(){
        System.out.println("Я лечу");
    }
}
