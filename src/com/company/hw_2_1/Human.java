package com.company.hw_2_1;

public class Human {
    int height;
    int time;
    String name;

    public Human(String name, int height, int time) {
        this.name=name;
        this.height = height;
        this.time = time;

    }

    public void run() {
        System.out.println("Бежит");
    }

    public void jump() {
        System.out.println("Прыгает");
    }
}
