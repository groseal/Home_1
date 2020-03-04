package com.company.hw7;

public class Cat {
    private String name;
    private int satiety;

    public Cat(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public int getSatiety(){
        return satiety;
    }

    public boolean satietyCat(int catAte) {
        if (catAte > 0) {
            satiety+=catAte;
            return true;
        } else return false;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " ест");
        plate.decreaseFood(10);
        satiety+=10;
    }
}
