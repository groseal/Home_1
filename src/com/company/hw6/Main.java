package com.company.hw6;

public class Main {
    public static void main(String[] args) {
        Cat musja = new Cat(100, 0, 1.8);
        Cat adolf = new Cat(201, 3, 2.2);
        Dog drujok = new Dog(400, 8, 0.3);
        Dog sharik = new Dog(550, 11, 0.6);

        musja.letRun(100);
        adolf.letJump(2);
        drujok.letSail(10);
        drujok.letRun(50);
        sharik.letRun(600);


    }
}
