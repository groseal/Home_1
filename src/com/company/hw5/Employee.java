package com.company.hw5;

public class Employee {
    public String name;
    public String position;
    public String email;
    public String telephone;
    public int salary;
    public int age;

    public Employee(String name, String position, String email, String telephone, int salary, int age) {
    this.name=name;
    this.position=position;
    this.email=email;
    this.telephone=telephone;
    this.salary=salary;
    this.age=age;
    }

    public void printEmployee() {
        System.out.println("ФИО "+name);
        System.out.println("Должность "+position);
        System.out.println("email "+email);
        System.out.println("Телефон "+telephone);
        System.out.println("Заработная плата "+salary);
        System.out.println("Возраст "+age);
        System.out.println();

    }

}
