/*
 2. Написать простой класс PhoneBook(внутри использовать HashMap):
  - В качестве ключа использовать фамилию
  - В каждой записи всего два поля: phone, e-mail
  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию,
  получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
  Следует учесть, что под одной фамилией может быть несколько записей. Итого
  должно получиться 3 класса Main, PhoneBook, Person.
*/
package com.company.hw2_3;

import java.util.*;

public class PhoneBook {
    HashMap<String, HashSet<String>> phone;
    HashMap<String, HashSet<String>> email;

    public PhoneBook() {
        this.phone = new HashMap<>();
        this.email = new HashMap<>();
    }

    public void addContact(String name, String numberPhone, String adresEmail) {
        HashSet<String> newPhoneBook = phone.getOrDefault(name, new HashSet<>());
        newPhoneBook.add(numberPhone);
        phone.put(name, newPhoneBook);

        HashSet<String> newEmailBook = email.getOrDefault(name, new HashSet<>());
        newEmailBook.add(adresEmail);
        email.put(name, newEmailBook);
    }

    public void addContact(String name, String numberPhone) {
        HashSet<String> newPhoneBook = phone.getOrDefault(name, new HashSet<>());
        newPhoneBook.add(numberPhone);
        phone.put(name, newPhoneBook);
    }

    public void searchPhone(String name) {
        System.out.println("Контакт " + name + " номер телефона " + phone.getOrDefault(name, new HashSet<>()));
    }

    public void searchEmail(String name) {
        System.out.println("Контакт " + name + " e-mail " + email.getOrDefault(name, new HashSet<>()));
    }
}





//ArrayList<Person> contacts;
//
//    public PhoneBook(ArrayList<Person> contacts) {
//        contacts = new ArrayList<>();
//    }
//
//    public void addContact(Person newContact){
//        contacts.add(newContact);
//    }
//
//    public ArrayList<Person>searchName(String name){
//        ArrayList<Person> foundNames =new ArrayList<>();
//        for (Person person: contacts){
//            if(person.name.equals(name)){
//                foundNames.add(person);
//            }
//        }
//        return foundNames;
//    }
//
//    public ArrayList<Person>searchNumberPhone(String numberPhone){
//        ArrayList<Person> foundNumberPhone =new ArrayList<>();
//        for (Person person: contacts){
//            if(person.name.equals(numberPhone)){
//                foundNumberPhone.add(person);
//            }
//        }
//        return foundNumberPhone;
//    }
//
//    public ArrayList<Person>searchEmail(String email){
//        ArrayList<Person> foundEmail =new ArrayList<>();
//        for (Person person: contacts){
//            if(person.name.equals(email)){
//                foundEmail.add(person);
//            }
//        }
//        return foundEmail;
//    }
//}
