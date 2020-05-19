package com.company.maraphon;

public class Wall implements Obstacles {
    int number;
    int height;

    public Wall(int number, int height) {
        this.number = number;
        this.height = height;
    }

    @Override
    public void overcomeObstacle(Competitors competitors) {
        competitors.jump(height);
    }
}



