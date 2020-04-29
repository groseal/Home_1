package com.company.hw3_1;

public class Fruit {
    float fruitWeight;

    public Fruit(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitWeight=" + fruitWeight +
                '}';
    }
}
