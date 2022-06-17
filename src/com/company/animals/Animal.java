package com.company.animals;

import com.company.birds.Duck;
import com.company.configuration.data.Questions;
import com.company.pets.Cat;
import com.company.pets.Dog;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say(){
        System.out.println("Я говорю");
    }
    public void go(){
        System.out.println("Я иду");
    }
    public void drink(){
        System.out.println("Я пью");
    }
    public void eat(){
        System.out.println("Я ем");
    }

  public String agePostFix(){
        int ageLastNumber = age % 10;
        boolean exclusion = (age % 100 >= 11) && (age % 100 <= 14);
        String old = "";

        if (ageLastNumber == 1)
            old = "год";
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            old = "лет";
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
            old = "года";
        if (exclusion) {
            old = "лет";
        }

        return old;
    }

    @Override
    public String toString(){
        return ("Привет! меня зовут "+ getName()+","+" мне "+getAge()+" "+agePostFix()+","+ " я вешу - "+getWeight()+" кг, мой цвет - "+getColor());
    }
    public static void createAnimal(Scanner sc, List<Animal> animals) {
        boolean isExit = true;
        while (isExit) {
            Questions.questionPresentation(Questions.WHICHANIMAL.getQuest());
            String animal = sc.next().toLowerCase().trim();
            switch (animal) {
                case "cat":
                    Animal cat = new Cat();
                    fillingAnimal(cat, sc);
                    animals.add(cat);
                    cat.say();
                    isExit = false;
                    break;
                case "dog":
                    Animal dog = new Dog();
                    fillingAnimal(dog, sc);
                    animals.add(dog);
                    dog.say();
                    isExit = false;
                    break;
                case "duck":
                    Animal duck = new Duck();
                    fillingAnimal(duck, sc);
                    animals.add(duck);
                    duck.say();
                    isExit = false;
                    break;
                default:
                    System.out.println("Введен некорректный класс животного. Повторите попытку");
                    break;
            }
        }
    }
    public static void fillingAnimal(Animal animal, Scanner scanner){
        Questions.questionPresentation(Questions.WHICHNAME.getQuest());
        animal.setName(scanner.next());
        Questions.questionPresentation(Questions.WHICHAGE.getQuest());
        setAgeValidation(animal,scanner);
        Questions.questionPresentation(Questions.WHICHCOLOR.getQuest());
        animal.setColor(scanner.next());
        Questions.questionPresentation(Questions.WHICHWIGHT.getQuest());
        setWightValidation(animal,scanner);
    }
    public static void setAgeValidation(Animal animal,Scanner scanner) {
       while (true) {
            try {
                String s = scanner.next();
                int number = Integer.parseInt(s);
                try {
                    if (number > 0 && number <= 100){
                        animal.setAge(number);
                        break;
                    }
                    else {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    System.out.println("Вы ввели возраст более 100 лет. Пожалуйста введите возраст менее 100 лет");
                }
            }
            catch (NumberFormatException ex) {
                    System.out.println("Вы ввели не число. Пожалуйста введите число");
                }
          }
        }
    public static void setWightValidation(Animal animal,Scanner scanner) {
        while (true) {
            try {
                String s = scanner.next();
                int number = Integer.parseInt(s);
                try {
                    if (number > 0 && number <= 1000){
                        animal.setWeight(number);
                        break;
                    }
                    else {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    System.out.println("Вы ввели отрицательный вес. Пожалуйста введите положительное число");
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число. Пожалуйста введите число");
            }
        }
    }
}
