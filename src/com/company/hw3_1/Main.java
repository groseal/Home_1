package com.company.hw3_1;

import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args) {
        String[] arr = {"java", "cool"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        swapsElements(arr, 0, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        arrToList(arr, list);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

        Apple apple1=new Apple(1f);
        Apple apple2=new Apple(1f);
        Apple apple3=new Apple(1f);
        Orange orange1=new Orange(1.5f);
        Orange orange2=new Orange(1.5f);
        Orange orange3=new Orange(1.5f);
        Box<Apple> appleBox= new Box<Apple>();
        Box<Orange> orangeBox=new Box<Orange>();
        Box<Orange> orangeBox1=new Box<Orange>();
        appleBox.listFruits.add(apple1);
        appleBox.listFruits.add(apple2);
        appleBox.listFruits.add(apple3);
        orangeBox.listFruits.add(orange1);
        orangeBox.listFruits.add(orange2);
        orangeBox.listFruits.add(orange3);
        orangeBox1.listFruits.add(orange1);
        orangeBox1.listFruits.add(orange2);
        orangeBox1.listFruits.add(orange3);

        for (int i = 0; i <orangeBox.listFruits.size() ; i++) {
            System.out.println(orangeBox.listFruits.get(i));
        }
        for (int i = 0; i <appleBox.listFruits.size() ; i++) {
            System.out.println(appleBox.listFruits.get(i));
        }
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        orangeBox.shiftFruitToAnotherBox(orangeBox1);
        appleBox.shiftFruitToAnotherBox(orangeBox1);
        for (int i = 0; i <orangeBox1.listFruits.size() ; i++) {
            System.out.println(orangeBox1.listFruits.get(i));
        }
        for (int i = 0; i <orangeBox.listFruits.size() ; i++) {
            System.out.println(orangeBox.listFruits.get(i));
        }
    }

    public static <T> void swapsElements(T[] arr, int element1, int element2) {
        if (arr[element1].equals(arr[element2])) {
            return;
        } else {
            T buffer = arr[element1];
            arr[element1] = arr[element2];
            arr[element2] = buffer;
            buffer = null;
        }
    }
    public static <T> void arrToList(T[] arr, ArrayList<T> list){
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
    }

}
