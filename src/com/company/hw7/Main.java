package com.company.hw7;

public class Main {
    public static void main(String[] args) {
        Cat murzik = new Cat("Мурзик", 0);
        Cat adolf = new Cat("Адольф", 0);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Бездомный1", 0);
        cats[1] = new Cat("Бездомный2", 0);
        cats[2] = new Cat("Бездомный3", 0);
        cats[3] = new Cat("Бездомный4", 0);
        cats[4] = new Cat("Бездомный5", 0);

        Plate plate = new Plate(40);

        murzik.eat(plate);
        plate.info();

        adolf.eat(plate);
        plate.info();

        for (Cat a : cats) {
            a.eat(plate);
            System.out.println("Кот " + a + " съел " + a.getSatiety() + " еды");
            plate.info();
        }
        plate.fillPlate(plate);

    }
}
