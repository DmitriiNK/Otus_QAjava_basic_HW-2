package com.company.configuration;

import com.company.configuration.data.MenuOptions;
import com.company.animals.Animal;
import com.company.configuration.data.Questions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Animal> animals = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        while (isExit){
            Questions.questionPresentation(Questions.MENUOPTIONS.getQuest());
            String choice = sc.next().toLowerCase().trim();
            if (choice.equalsIgnoreCase(MenuOptions.ADD.getCmd())) {
                Animal.createAnimal(sc,animals);
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
}