package com.company.hw2_5;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static final int SIZE = 1000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();
        sequentialCalculationFormula(arr);
        System.out.println("Время выполнения вычислений по формуле беспоточным методом " + (System.currentTimeMillis() - time) + " миллисекунд.\n");
        float[] arr1 = new float[SIZE];
        System.arraycopy(arr, 0, arr1, 0, SIZE);
        Arrays.fill(arr, 1);
        time = System.currentTimeMillis();
        parallelCalculationsFormula(arr);
        System.out.println("\nВремя выполнения вычислений по формуле поточным методом " + (System.currentTimeMillis() - time) + " миллисекунд.\n");
        if (Arrays.equals(arr1, arr)) {
            System.out.println("Результирующие массивы совпадают.");
        }
    }

    static private void sequentialCalculationFormula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static private void parallelCalculationsFormula(float[] arr) {
        AtomicLong time = new AtomicLong(System.currentTimeMillis());
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        System.out.println("\tВремя разбивки переданного массива на две части " + (System.currentTimeMillis() - time.get()) + " миллисекунд.");

        Thread newThreadArr1 = new Thread(() -> {
            time.set(System.currentTimeMillis());
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("\tВремя выполнения 1 потока " + (System.currentTimeMillis() - time.get()) + " миллисекунд.");
        });

        Thread newThreadArr2 = new Thread(() -> {
            time.set(System.currentTimeMillis());
            int i = H;
            for (int k = 0; k < arr2.length; k++, i++) {
                arr2[k] = (float) (arr2[k] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("\tВремя выполнения 2 потока " + (System.currentTimeMillis() - time.get()) + " миллисекунд.");
        });

        time.set(System.currentTimeMillis());
        newThreadArr1.start();
        newThreadArr2.start();

        try {
            newThreadArr1.join();
            newThreadArr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\tВремя выполнения потоков " + (System.currentTimeMillis() - time.get()) + " миллисекунд.");

        time.set(System.currentTimeMillis());
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, arr2.length);
        System.out.println("\tВремя склейки массивов " + (System.currentTimeMillis() - time.get()) + " миллисекунд.");
    }
}
