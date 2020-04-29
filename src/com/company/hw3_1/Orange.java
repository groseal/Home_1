package com.company.hw3_1;

public class Orange extends Fruit {
    public Orange(float fruitWeight) {
        super(fruitWeight);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "fruitWeight=" + fruitWeight +
                '}';
    }
}
