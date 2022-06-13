package com.company.birds;

import com.company.pets.Flying;
import com.company.animals.Animal;

public class Duck extends Animal implements Flying {
    public void say(){
        System.out.println("Кря");
    }
    public void fly(){
        System.out.println("Я лечу");
    }
}
