package com.company.hw2_2;
/*
1. Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
3. Ваши методы должны бросить исключения в случаях:
   Если размер матрицы, полученной из строки, не равен 4x4;
   Если в одной из ячеек полученной матрицы не число; (например символ или слово)
4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
5. * Написать собственные классы исключений для каждого из случаев
*/

import java.util.Arrays;

public class Main {
    //Задание 1.
    static String[][] stringToArr(String line) throws MyExceptionSizeMas {
        String[] arr = line.split("\\\\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n");
        String[][] stringToArr = new String[arr.length][];
        int i = 0;
        for (String a : arr) {
            stringToArr[i++] = a.split(" ");
        }

        try {
            if (stringToArr.length != 4) throw new MyExceptionSizeMas();
            for (int q = 0; q < stringToArr.length; q++) {
                if (stringToArr[q].length != 4) throw new MyExceptionSizeMas();
                for (int j = 0; j < stringToArr.length; j++) {
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("\nНеверный тип данных в массиве!");
            e.printStackTrace();
        }

        return stringToArr;
    }

    //Задание 2.
    static int matTransformationsMas(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    int k = Integer.parseInt(arr[i][j]);
                    sum += k;
                } catch (NumberFormatException e) {
                    System.out.println("\nНеверный тип данных в массиве!");
                    e.printStackTrace();
                }
            }
        }
        sum = sum / 2;
        return sum;
    }


    public static void main(String[] args) throws MyExceptionSizeMas {
        String line = "10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 h";
        String[][] arr = stringToArr(line);

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(" " + string + " ");
            }
            System.out.println();
        }

        int a = matTransformationsMas(arr);
        System.out.println("\nСумма всех элементов двумерного \nмассива деленная на 2 равна: " + a);
    }
}
