package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String menuOptions = "Выбирите необходимое действие: \n add/list/exit";
    static String whichAnimal = "Выбирите необходимое животное: \n cat/dog/duck";
    static String whichName = "Укажите Имя";
    static String whichAge = "Укажите Возраст";
    static String whichColor = "Укажите Цвет";
    static String whichWight = "Укажите Вес";

    public static void main(String[] args) throws IOException {
        List<Animal> animals = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        while (isExit){
            questionPresentation(menuOptions);
            String choice = sc.next().toLowerCase().trim();
            if (choice.equalsIgnoreCase(MenuOptions.ADD.getCmd())) {
                createAnimal(sc,animals);
            }
            else if (choice.equalsIgnoreCase(MenuOptions.LIST.getCmd())){
                animals.forEach(animal -> System.out.println(animal) );
            }
            else if (choice.equalsIgnoreCase(MenuOptions.EXIT.getCmd())){
                isExit = false;
            }
            else {
                System.out.println("Вы ввели неверную команду. Повторите попытку");
            }
        }

    }
    public static void questionPresentation (String s){
        System.out.println(s);
    }
    public static void fillingAnimal(Animal animal, Scanner scanner){
        questionPresentation(whichName);
        animal.setName(scanner.next());
        questionPresentation(whichAge);
        setAgeValidation(animal,scanner);
        questionPresentation(whichColor);
        animal.setColor(scanner.next());
        questionPresentation(whichWight);
        setWightValidation(animal,scanner);
    }
    public static void createAnimal(Scanner sc,List<Animal> animals) {
        boolean isExit = true;
        while (isExit) {
            questionPresentation(whichAnimal);
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
    public static void setAgeValidation(Animal animal,Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Вы ввели не число.Пожалуйста введите число");
            scanner.next();
        }
        animal.setAge(scanner.nextInt());
    }
    public static void setWightValidation(Animal animal,Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Вы ввели не число.Пожалуйста введите число");
            scanner.next();
        }
        animal.setWeight(scanner.nextInt());
    }
}