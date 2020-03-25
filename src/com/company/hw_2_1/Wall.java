package com.company.hw_2_1;

public class Wall {
    int heightWall;

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    public void jamp(int height) {
        if (height > heightWall) {
            System.out.println("Успешно запрыгнул на стену.");
        } else System.out.println("Не смог запрыгнуть на стену.");
    }
}
