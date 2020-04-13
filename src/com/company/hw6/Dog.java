package com.company.hw6;

public class Dog extends Animals {

    public Dog(int run, int sail, double jump) {
        super(run, sail, jump);

    }

    @Override
    public boolean letRun(int run) {
        int i = (int) (Math.random()*100);
        if (run <= i) {
            System.out.println("run: true");
            return true;
        }
        System.out.println("run: false");
        return false;
    }

    @Override
    public boolean letSail(int sail) {
        if (sail <= 10) {
            System.out.println("sail: true");
            return true;
        }
        System.out.println("sail: false");
        return false;
    }

    @Override
    public boolean letJump(double jump) {
        if (jump <= 0.5) {
            System.out.println("jump: true");
            return true;
        }
        System.out.println("jump: false");
        return false;
    }
}
