package com.company.hw2_5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        consistently(arr);
        parallel(arr);
    }

    static void consistently(float[] arr) {
        for (float i : arr) {
            arr[(int) i] = 1;
        }
        long a = System.currentTimeMillis();
        for (float i : arr) {
            arr[(int) i] = (float) (arr[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения вычислений по формуле беспоточным методом " + (System.currentTimeMillis() - a) + " миллисекунд.");
    }

    static void parallel(float[] arr) {
        for (float i : arr) {
            arr[(int) i] = 1;
        }
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread newThreadArr1 = new Thread(() -> {
            for (float i : arr1) {
                arr1[(int) i] = (float) (arr1[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread newThreadArr2 = new Thread(() -> {
            for (float i : arr2) {
                arr2[(int) i] = (float) (arr2[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        newThreadArr1.start();
        long a = System.currentTimeMillis();
        try {
            newThreadArr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newThreadArr2.start();
        try {
            newThreadArr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Время выполнения вычислений по формуле поточным методом " + (System.currentTimeMillis() - a) + " миллисекунд.");
    }
}
