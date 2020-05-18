package com.company.marathon;

public class Creatures implements Competitors {
    String type;
    String name;

    int maxRun;
    int maxJump;

    boolean onDistance;


    public Creatures(String type, String name, int maxRun, int maxJump) {
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.onDistance = true;

    }

    @Override
    public void run(int dist) {
        if (dist <= maxRun) {
            System.out.println(type + " " + name + " успешно пробежал");
        } else {
            System.out.println(type + " " + name + " не пробежал");
            onDistance = false;
        }

    }

    @Override
    public void jump(int height) {
        if (height <= maxJump) {
            System.out.println(type + " " + name + " перепрыгнул стену");
        } else {
            System.out.println(type + " " + name + " не перепыгнул стену");
            onDistance = false;
        }
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        if (!onDistance){
            System.out.println(type + " " + name + " преодолел дистанцию");
        }else {
            System.out.println(type + " " + name + " сошел с дистанции");
        }
    }
}
