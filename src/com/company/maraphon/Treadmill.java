package com.company.maraphon;

public class Treadmill implements Obstacles {
    int number;
    int length;

    public Treadmill(int number, int length) {
        this.number = number;
        this.length = length;
    }

    @Override
    public void overcomeObstacle(Competitors competitors) {
        competitors.run(length);
    }
}

