package com.company.hw1;

public class Bissextile {

    public void bissextile (int age) {
        if ((age % 4 == 0) && (age % 100 != 0) || (age % 400 == 0))
            System.out.println("Год "+ age +" високосный.");
        else System.out.println("Год "+ age +" не високосный.");
        }

}
