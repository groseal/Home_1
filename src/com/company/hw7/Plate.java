package com.company.hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void fillPlate(Plate plate) {
        if (food <= 0) {
            System.out.println("Тарелка пуста");
            food=100;
            System.out.println("Добавили еду в тарелку");
            info();
        }
    }

    public void info() {
        if (food <= 0) {
            System.out.println("Тарелка пуста");
        } else {
            System.out.println("В тарелке осталось " + food + " еды");
        }
    }

    public void decreaseFood(int amount) {
        food -= amount;
    }

}
