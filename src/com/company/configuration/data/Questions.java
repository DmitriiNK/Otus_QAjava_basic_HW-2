package com.company.configuration.data;

public enum Questions {
    MENUOPTIONS("Выбирите необходимое действие: \n add/list/exit"),
    WHICHANIMAL("Выбирите необходимое животное: \n cat/dog/duck"),
    WHICHNAME("Укажите Имя"),
    WHICHAGE("Укажите Возраст"),
    WHICHCOLOR("Укажите Цвет"),
    WHICHWIGHT("Укажите Вес");



    public String quest;
    Questions(String quest) {
        this.quest = quest;
    }
    public String getQuest() {
        return quest;
    }
    public static void questionPresentation (String s){
        System.out.println(s);
    }
}
