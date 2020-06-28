package com.company.hw3_1_1;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Integer[] a = {1, 2, 3, 4, 5};
        String[] b = {"q", "w", "e", "r", "t", "y"};
        main.print(a);
        main.swapArrayElements(0, a.length - 1, a);
        main.print(a);
        main.print(b);
        main.swapArrayElements(0, b.length - 1, b);
        main.print(b);

        Box<Orange> orangeBox = new Box();
        Box<Apple> appleBox = new Box();
        Box<Apple> appleBox1 = new Box();


        for (int i = 0; i < 5; i++) {
            orangeBox.boxFruit.add(new Orange());
            appleBox.boxFruit.add(new Apple());
            appleBox1.boxFruit.add(new Apple());
        }

        System.out.println("Коробка с апельсинами весит "+orangeBox.getWeight());
        System.out.println("Коробка с яблоками весит "+appleBox.getWeight());
        System.out.println("Коробка с яблоками весит "+appleBox1.getWeight());
        System.out.println(orangeBox.compare(appleBox));
        System.out.println(appleBox.compare(appleBox1));
        appleBox.boxToBox(appleBox1);

        Apple apple = new Apple();
        appleBox.addFruitToBox(apple);
        appleBox.addFruitToBox(apple);

    }


    public <T> void swapArrayElements(int a, int b, T[] mas) {
        T x = mas[a];
        mas[a] = mas[b];
        mas[b] = x;
    }

    public <T> ArrayList<T> masToAL(T[] mas) {
        return new ArrayList<>(asList(mas));
    }

    public <T> void print(T[] mas) {
        for (T e : mas) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
