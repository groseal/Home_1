package com.company.hw3_1_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> boxFruit = new ArrayList<T>();

    public float getWeight() {
        float weightBox = 0;
        for (T e : boxFruit) {
            weightBox += e.getWeight();
        }
        return weightBox;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void boxToBox(Box<T> box) {
        if (this.boxFruit.equals(box)) {
        } else {
            box.boxFruit.addAll(this.boxFruit);
            this.boxFruit.removeAll(box.boxFruit);
        }
    }

    public void addFruitToBox(Fruit fruit) {
        int x = 0;
        for (T e : boxFruit) {
            if (fruit.equals(e)) {
                x++;
            }
            if (x == 0) {
                boxFruit.add((T) fruit);
            } else {
                System.out.println("Этот фрукт уже в коробке");
            }
        }
    }
}
