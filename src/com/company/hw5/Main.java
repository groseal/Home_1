package com.company.hw5;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Громов Сергей Александрович", "ювелир-закрепщик", "groseal@mail.ru", "+79536504777", 35000, 33);
        Employee emp2 = new Employee("Кузнецова Екатерина Ивановна", "ювелир-монтировщик", "_", "+79536506565", 23000, 29);
        Employee emp3 = new Employee("Григорьев Роман Николаевич", "мастер участка закрепки", "kjhgjhgdf@mail.ru", "+7975656754", 65000, 37);
        Employee emp4 = new Employee("Лисина Екатерина Павловна", "работник склада драгметалла", "dfsagdsal@mail.ru", "", 15000, 26);
        Employee emp5 = new Employee("Дебилко Жадно Кривоглазович", "начальник производства", "naebu@mail.ru", "+7657545456", 1_000_000, 45);

        emp1.printEmployee();
        emp2.printEmployee();
        emp3.printEmployee();
        emp4.printEmployee();
        emp5.printEmployee();

        Employee[] emp = new Employee[5];
        emp[0] = emp1;
        emp[1] = emp2;
        emp[2] = emp3;
        emp[3] = emp4;
        emp[4] = emp5;

        for (int i = 0; i < emp.length; i++) {
            if (emp[i].age > 40) {
                System.out.println("Сотрудники старше 40 лет:");
                emp[i].printEmployee();
                System.out.println();

            }
        }
    }
}