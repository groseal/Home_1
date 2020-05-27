package com.company.hw2_3_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        dictionary("A S D F G F D R G D F C G F S A N z");

        PhoneBook pb = new PhoneBook();
        pb.add("Сергей", "89536504777");
        pb.add("Сергей", "89536504777");
        pb.add("Сергей", "89536638102");
        pb.add("МЧС", "112");

        pb.get("Сергей");
        pb.get("МЧС");
        pb.get("Катя");
    }

    public static void dictionary(String str) {
        Map<String, Integer> dictionary = new HashMap<>();
        String[] mas = str.split(" ");
        for (int i = 0; i < mas.length; i++) {
            if (dictionary.isEmpty() || dictionary.containsKey(mas[i]) == false) {
                dictionary.put(mas[i], 1);
            } else {
                int a = dictionary.get(mas[i]) + 1;
                dictionary.put(mas[i], a);
            }
        }
        System.out.println(dictionary);
    }


    public static class PhoneBook {
        HashMap<String, HashSet<String>> number;

        public PhoneBook() {
            this.number = new HashMap<>();
        }

        public void add(String name, String numberPhone) {
            HashSet<String> newPhoneBook = number.getOrDefault(name, new HashSet<>());
            newPhoneBook.add(numberPhone);
            number.put(name, newPhoneBook);
        }

        public void get(String name) {
            System.out.println(name + ": " + number.get(name));
        }
    }
}


