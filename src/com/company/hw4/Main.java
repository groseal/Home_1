package com.company.hw4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE_X = 7;//размер поля
    public static int SIZE_Y = 7;//размер поля
    public static int DOTS_TO_WIN = 3; //количество фишек для победы
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //Проверка победы.
    public static boolean checkWin(char symb) {
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//        return false;

        int count = 0;
        //int j = 0;
        //Проверка строк
        for (int i = 0; i < SIZE_Y; i++) {
            count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == symb) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                } else count = 0;
            }
        }
        //Проверка столбцов
        for (int i = 0; i < SIZE_X; i++) {
            count = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                if (map[j][i] == symb) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                } else count = 0;
            }
        }
        //Проверка диагоналей
        count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][i] == symb && map[i + 1][i + 1] == symb) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                } else count = 0;
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map.length; j++) {
//                int k = map.length - 1;
//                if (map[k-i][i] == symb) {
//                    count++;
//                    if (count == DOTS_TO_WIN) {
//                        return true;
//                    }
//                } else count = 0;
//            }
//        }
        return false;
    }

    //Проверка заполнена ли карта
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //Ход компьютера.
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    //Ход человека.
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    //Проверка ячеек. Метод isCellValid()
    // проверяет возможность установки фишки в указанную ячейку.
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    //Инициализация поля. При запуске программы необходимо
    // инициализировать поле и заполнить все его ячейки символом,
    // обозначающим пустое поле.
    public static void initMap() {
        map = new char[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // Вывод поля в консоль.
    public static void printMap() {
        for (int i = 0; i <= SIZE_X; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
