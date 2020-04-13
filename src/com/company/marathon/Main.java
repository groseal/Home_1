package com.company.marathon;

public class Main {
    public static void main(String[] args) {
        Competitors[] competitors = {
                new Cat("Васька", 30, 2),
                new Cat("Марсик", 50, 3),
                new Human("Володя", 150, 2),
                new Human("Эльвира", 10, 1),
                new Robot("Федор", 0, 0),
                new Robot("R2D2", 80, 0),
                new Robot("Boston", 200000, 5)
        };

        Obstacles[] obstacles = {
                new Wall(1, 2),
                new Treadmill(1, 30),
                new Wall(2, 1),
                new Treadmill(2, 80)
        };
        for (Competitors com : competitors) {
            for (Obstacles obs : obstacles) {
                obs.overcomeObstacle(com);
                if (!com.isDistance()) break;
            }
        }
        for (Competitors com : competitors) {
            com.info();
        }
    }
}
