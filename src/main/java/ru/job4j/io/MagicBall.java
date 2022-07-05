package ru.job4j.io;
import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Здравствуйте! Эта программа дает ответы "
                + "на любые вопросы: да или нет!");
        System.out.println("Введите свой вопрос и нажмите Enter.");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Да!");
            case 1 -> System.out.println("Нет!");
            default -> System.out.println("Может быть...");
        }
    }
}
