package com.company.hw_2_1;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Cat1",120, 40);
        Cat cat2 = new Cat("Cat2",90, 60);
        Robot robot1 = new Robot("Robot1",0, 110);
        Robot robot2 = new Robot("Robot2",65, 30);
        Human human1 = new Human("Human1",70, 100);
        Human human2 = new Human("Robot2",85, 80);

        Treadmill treadmill1 = new Treadmill(50);
        Treadmill treadmill2 = new Treadmill(110);
        Wall wall1 = new Wall(90);
        Wall wall2 = new Wall(105);

        String competitors[]={};
        String obstacles[]={};
    }
}
