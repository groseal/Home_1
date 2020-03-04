package com.company.hw6;

public class Cat extends Animals {


    public Cat(int run, int sail, double jump) {
        super(run, sail, jump);
    }

    @Override
    public boolean letRun(int run) {
        if (run <= 200) {
            System.out.println("run: true");
            return true;
        }
        System.out.println("run: false");
        return false;
    }

    @Override
    public boolean letSail(int sail) {
        if (sail <= 0) {
            System.out.println("run: true");
            return true;
        }
        System.out.println("sail: false");
        return false;
    }

    @Override
    public boolean letJump(double jump) {
        if (jump <= 2) {
            System.out.println("run: true");
            return true;
        }
        System.out.println("jump: false");
        return false;
    }
}
