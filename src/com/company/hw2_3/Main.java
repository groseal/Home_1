/*
1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
  - Найти список слов, из которых состоит текст (дубликаты не считать);
  - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 */
package com.company.hw2_3;

import java.util.*;

public class Main {
    //Делаю из строки масиив
    static String[] stringToArr(String line) {
        String[] arr = line.split(" ");
        System.out.println("Массив из строки:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n");
        return arr;
    }

    //Словарь
    static Set<String> vocabulary(String[] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println("Словарь:\n" + set + "\n");
        return set;
    }

    //Сколько раз встречается каждое слово
    static HashMap<String, Integer> arrToMap(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], 0);
//            map.put(arr[i], map.get(arr[i]) + 1);
//        }
        for (String a : arr) {
            if (map.containsKey(a)) {
                int count = map.get(a);
                map.put(a, ++count);
            } else {
                map.put(a, 1);
            }
        }
        System.out.println("Сколько раз встречается каждое слово:\n" + Arrays.asList(map) + "\n");
        return map;
    }


    public static void main(String[] args) {
//        String a = "a a a a Тяга программистов к пониманию заставляет их инстинктивно создавать взаимодействие, " +
//                "приближенное к внутренним механизмам продукта. Вместо того, чтобы делать программы, " +
//                "отражающие конечные цели пользователей, они отражают работу внутреннего механизма программы. " +
//                "Естественно, что программисты не испытывают неудобств, пользуясь такими программами, поскольку, " +
//                "понимая принцип работы программы, они способны понять и способы ее применения.";
        String a = "a a s d ff b n h j g h h yy h g f d ee r r d f s d r t ee f yy";
        System.out.println("Строка: \n" + a + "\n");
        String[] mas = stringToArr(a);
        Set<String> set = vocabulary(mas);
        HashMap<String, Integer> map = arrToMap(mas);

        //Телефонная книга
        PhoneBook book = new PhoneBook();
        book.addContact("Сергей", "999", "пвпр@иавч");
        book.addContact("Сергей", "777");
        book.addContact("Анна", "555", "выарпв@апавч");
        book.addContact("Лида", "444", "ронгонг@евч");
        book.addContact("Оля", "333", "пап@авч");

        book.searchPhone("Сергей");
        book.searchPhone("Анна");
        book.searchEmail("Сергей");




//        Person q1 = new Person("Сергей", "999", "пвпр@иавч");
//        Person q2 = new Person("Сергей", "777", "полнлоав@ч");
//        Person q3 = new Person("Анна", "555", "выарпв@апавч");
//        Person q4 = new Person("Лида", "444", "ронгонг@евч");
//        Person q5 = new Person("Оля", "333", "пап@авч");
//        ArrayList contacts= new ArrayList<>();
//        contacts.add(q1);
//        contacts.add(q2);
//        contacts.add(q3);
//        contacts.add(q4);
//        contacts.add(q5);
//        PhoneBook book = new PhoneBook(contacts);
//        System.out.println(contacts);
        //PhoneBook.searchName(contacts);
    }
}
