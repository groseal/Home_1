package com.company.hw_2_1;

public class Treadmill {
    int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public void run(int time) {
        if (time < length) {
            System.out.println("Успешно пробежал по беговой дорожке.");
        } else System.out.println("Не смог пробежать по беговой дорожке.");
    }

}
