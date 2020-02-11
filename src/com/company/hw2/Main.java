package com.company.hw2;

import com.company.hw1.*;
import sun.awt.geom.AreaOp;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void task1() {
        int[] mas1 = new int[10];
        System.out.print("Задание 1. \nЭлементы массива: \t");
        for (int i = 0; i < mas1.length; i++) {
            mas1[i] = (int) (Math.random() + 0.5);
            System.out.print(mas1[i] + " ");
        }
        System.out.print("\nИзмененный массив: \t");

        for (int i = 0; i < mas1.length; i++) {
            if (mas1[i] == 1) mas1[i] = 0;
            else mas1[i] = 1;
            System.out.print(mas1[i] + " ");
        }
        System.out.println("\n");
    }

    //Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void task2() {
        int[] mas2 = new int[8];
        System.out.print("Задание 2. \nЭлементы массива: \t");
        for (int i = 0; i < mas2.length; i++) {
            mas2[i] = i * 3;
            System.out.print(mas2[i] + " ");
        }
        System.out.println("\n");
    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void task3() {
        int[] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Задание 3. \nИсходный массив: \t");
        for (int i = 0; i < mas3.length; i++) {
            System.out.print(mas3[i] + "\t");
        }
        System.out.println();
        System.out.print("Измененный массив:\t");
        for (int i = 0; i < mas3.length; i++) {
            if (mas3[i] < 6) {
                mas3[i] *= 2;
                System.out.print(mas3[i] + "\t");
            } else
                System.out.print(mas3[i] + "\t");
        }
        System.out.println("\n");
    }

    //Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void task4() {
        int a = 5;
        int[][] mas4 = new int[a][a];
        System.out.println("Задание 4.");
        for (int i = 0; i < mas4.length; i++) {
            for (int j = 0; j < mas4.length; j++) {
                mas4[i][i] = 1;
                int k = mas4.length - 1;
                mas4[k - i][i] = 1;
            }
        }
        for (int[] row : mas4) {
            for (int k : row) {
                System.out.print(" " + k + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Задать одномерный массив и найти
    // в нем минимальный и максимальный элементы (без помощи интернета);
    public static void task5() {
        int[] mas5 = new int[5];
        int min, max;
        System.out.print("Задание 5. \nЭлементы массива: \t");
        for (int i = 0; i < mas5.length; i++) {
            mas5[i] = (int) (Math.random() * 10);
            System.out.print(mas5[i] + " ");
        }
        min = max = mas5[0];
        for (int o = 1; o < mas5.length; o++) {
            if (min >= mas5[o]) min = mas5[o];
            if (max <= mas5[o]) max = mas5[o];
        }
        System.out.println("\nМинимальный элемент массива равен " + min);
        System.out.println("Максимальный элемент массива равен " + max + "\n");
    }

    //Написать метод, в который передается не пустой одномерный
    // целочисленный массив, метод должен вернуть true, если в массиве
    // есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean task6(int[] mas6) {
        boolean l1 = false;
        double g = 0;
        int g1 = 0;
        for (int i = 0; i < mas6.length; i++) {
            g += mas6[i];
        }
        for (int i = 0; i < mas6.length; i++) {
            g1 += mas6[i];
            if (g1 == g / 2) {
                l1 = true;
                break;
            } else l1 = false;
        }
        return l1;
    }

    //Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен
    // сместить все элементы массива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void task7(int[] mas7, int n) {
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int a=mas7[mas7.length - 1];
                for (int j = 0; j < mas7.length-1; j++) {
                    mas7[mas7.length-1-j]=mas7[mas7.length-2-j];
                    //int a = mas7[j];
                    //mas7[j] = mas7[j + 1];
                    //mas7[j + 1] = a;
                }
                mas7[0]=a;
            }
        } else {
            //int a;
            n*=-1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < mas7.length - 1; j++) {
                    int a = mas7[j];
                    mas7[j] = mas7[j + 1];
                    mas7[j + 1] = a;
                }
            }
        }
        System.out.print("Измененный мвссив: \t");
        for (int k = 0; k < mas7.length; k++)
            System.out.print(mas7[k] + " ");
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        int[] mas = new int[7];
        System.out.print("Задание 6. \nЭлементы массива: \t");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 9);
            System.out.print(mas[i] + " ");
        }
        boolean g = task6(mas);
        System.out.println("\n" + g);

        System.out.print("\nЗадание 7. \nЭлементы массива: \t");
        for (int i = 0; i < mas.length; i++) System.out.print(mas[i] + " ");
        System.out.println();
        int n = -3;
        task7(mas, n);
    }
}
