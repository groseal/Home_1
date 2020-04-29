package com.company.hw3_1;

public class Apple extends Fruit {
    public Apple(float fruitWeight) {
        super(fruitWeight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "fruitWeight=" + fruitWeight +
                '}';
    }
}
