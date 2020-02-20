package com.company.hw3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
/*
 Написать программу, которая загадывает случайное число от 0 до 9,
 и пользователю дается 3 попытки угадать это число. При каждой попытке
 компьютер должен сообщить больше ли указанное пользователем число чем
 загаданное, или меньше. После победы или проигрыша выводится запрос –
 «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/
        int answerUser;
        do {
            int randomNumber = (int) (Math.random() * 10);
            System.out.println("Угадай загаданное число от 0 до 9: ");

            for (int i = 1; i < 5; i++) {
                answerUser = in.nextInt();
                if (answerUser == randomNumber) {
                    System.out.println("Поздравляю, вы угадали!\n");
                    break;
                } else if (answerUser < randomNumber) {
                    System.out.println("Не верно, загаданное число больше. Поробуйте снова. " +
                            "\nУгадай загаданное число от 0 до 9: ");
                } else if (answerUser > randomNumber) {
                    System.out.println("Не верно, загаданное число меньше. Поробуйте снова. " +
                            "\nУгадай загаданное число от 0 до 9: ");
                }
                if (i == 3) {
                    System.out.println("Вы проиграли.\nБыло загадано число " + randomNumber);
                    break;
                }
            }

            System.out.println("Нажмите 1 для повторения, 0 для выхода.");
            answerUser = in.nextInt();
            System.out.println();
        } while (answerUser == 1);


/*Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
"broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
"mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у
пользователя, сравнивает его с загаданным словом и сообщает, правильно ли
ответил пользователь.

Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы
    */

        String[] words = {"apple", "apricot", "avocado", "banana", "broccoli", "carrot",
                "cherry", "garlic", "grape", "kiwi", "leak", "lemon", "mango",
                "melon", "mushroom", "nut", "olive", "orange", "pea", "peanut", "pear",
                "pepper", "pineapple", "potato", "pumpkin"};
        StringBuilder answer = new StringBuilder("###############");
        String targetWord = "apple";//words[random.nextInt(words.length)];
        String inputWord = "###############";

        while (!targetWord.equals(inputWord)) {
            System.out.println(answer);

            System.out.println("Угадай загаданное слово: ");
            inputWord = in.next();
            System.out.println();

            int lengthInputWord = inputWord.length();
            if (inputWord.length() > targetWord.length()) {
                continue;}

            else {
                for (int i = 0; i < lengthInputWord; i++) {
                    char a = targetWord.charAt(i);
                    char b = inputWord.charAt(i);
                    if (a == b) {
                        answer.setCharAt(i, a);
                    }
                }
            }
        }
        System.out.println("Угадали!");
    }
}



