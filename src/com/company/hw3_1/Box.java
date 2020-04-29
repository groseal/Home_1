package com.company.hw3_1;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable<Box> {
    ArrayList<T> listFruits;

    public Box() {
        this.listFruits = new ArrayList<>();
    }

    //Вес коробки
    public float getWeight() {
        float count = 0f;
        for (int i = 0; i < listFruits.size(); i++) {
            count += listFruits.get(i).getFruitWeight();
        }
        return count;
    }

    //Сравнение коробок
    public boolean compare(Box boxFruits) {
        return Math.abs(this.getWeight() - boxFruits.getWeight()) < 0.00001;
    }


    //Пересыпание фруктов в другую коробку
    public void shiftFruitToAnotherBox(Box another) {
        for (int i = 0; i < listFruits.size(); i++) {
            another.listFruits.add(this.listFruits.get(i));
        }
        this.listFruits.removeAll(this.listFruits);

    }

    //Добавление фруктов в коробку
    public static void addFruitInBox(Box boxFruits) {

//        Apple apple3=new Apple(1f);
//
//        Box.listFruits.add(apple1);
    }

    @Override
    public int compareTo(Box another) {
        if (this.listFruits.equals(another.listFruits)) {
            return 1;
        } else {
            return 0;
        }
    }
}