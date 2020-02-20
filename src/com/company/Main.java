package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
	//Переменные и их инициализация
    System.out.println("\nЗадание 2:\n");
    byte q1 = 1;
    short q2 = 2;
    int q3 = q1 + q2;
    float q4 = q3 * q3;
    double q5 = q4/5;
    char q6 = '\\';
    boolean q7 = true;
    String q8 = "Я люблю JAVA";
    System.out.println(q1+"\n"+q2+"\n"+q3+"\n"+q4+"\n"+q5+"\n"+q6+"\n"+q7+"\n"+q8);

    //Написать метод вычисляющий выражение a * (b + (c / d))
    //и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    System.out.println("\nЗадание 3:\n");
    Formula x = new Formula();
        int a1; int b1; int c1; int d1;
        int res;

            System.out.print("a: ");
            a1 = in.nextInt();
            System.out.print("b: ");
            b1 = in.nextInt();
            System.out.print("c: ");
            c1 = in.nextInt();
            System.out.print("d: ");
            d1 = in.nextInt();
        res = x.form(a1, b1, c1, d1);
    System.out.println("Результат вычисления по формуле равен "+ res);

    //Написать метод, принимающий на вход два числа,
    // и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;
    System.out.println("\nЗадание 4:\n");
    Diap g = new Diap();
    int f1, h1;
    boolean g1;
    System.out.print("Ведите первое число: ");
    f1 = in.nextInt();
    System.out.print("Введите второе число: ");
    h1 = in.nextInt();
    g1 = g.diap (f1, h1);
    System.out.println(g1);

    //Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали,
    // или отрицательное;
    // Замечание: ноль считаем положительным числом.
    System.out.println("\nЗадание 5:\n");
    PositiveOrNegative num = new PositiveOrNegative();
    System.out.print("Введите целое число: ");
    int num1 = in.nextInt();
    num.number(num1);

    //Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное
    System.out.println("\nЗадание 6:\n");
    Negative j1 = new Negative();
    int j2;
    boolean j3;
    System.out.print("Введите целое число: ");
    j2 = in.nextInt();
    j3 = j1.neg(j2);
    System.out.print(j3);


    //Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    System.out.println("\nЗадание 7:\n");
    Hello h = new Hello();
    System.out.print("Введите имя: ");
    String h5 = in.nextLine();
    h.hello(h5);


    //Написать метод, который определяет является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным,
    // кроме каждого 100-го, при этом каждый 400-й – високосный.
    System.out.println("\nЗадание 8:\n");
    Bissextile age1 = new Bissextile();
    System.out.print("Введите год: ");
    int age2 = in.nextInt();
    age1.bissextile(age2);

    }


}

