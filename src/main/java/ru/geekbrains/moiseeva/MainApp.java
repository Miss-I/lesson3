package ru.geekbrains.moiseeva;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StartGame();
        while (true) {
            System.out.println("Повторить игру снова? 1 - ДА, 2 - НЕТ");
            Scanner sc = new Scanner(System.in);
            int againOrNot = sc.nextInt();
            if (againOrNot == 1) {
                StartGame();
            } else if (againOrNot == 2) {
                break;
            }
        }

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        String aiWord = words[rand.nextInt(words.length)];
        String userAnswer = AskUser();
        String str = "###############";
        char[] prepareAnswer = str.toCharArray();
        while (true) {
            if (aiWord.equals(userAnswer)) {
                System.out.println("Вы угадали!");
                break;
            } else if (!aiWord.equals(userAnswer)) {
                if (aiWord.length() <= userAnswer.length()) {
                    for (int i = 0; i < aiWord.length(); i++) {
                        char fromAi = aiWord.charAt(i);
                        char fromUser = userAnswer.charAt(i);
                        if (fromAi == fromUser) {
                            prepareAnswer[i] = fromUser;
                        }
                    }
                } else if (aiWord.length() > userAnswer.length()) {
                    for (int i = 0; i < userAnswer.length(); i++) {
                        char fromAi = aiWord.charAt(i);
                        char fromUser = userAnswer.charAt(i);
                        if (fromAi == fromUser) {
                            prepareAnswer[i] = fromUser;
                        }
                    }
                }
                for (int i = 0; i < prepareAnswer.length; i++) {
                    System.out.print(prepareAnswer[i]);
                }
                userAnswer = AskUser();
            }
        }


    }

    public static void StartGame() {
        Random rand = new Random();
        int answer = rand.nextInt(10);
        for (int i = 0; i <= 3; i++) {
            if (i == 3) {
                System.out.println("К сожалению, Вы проиграли.");
                break;
            }
            Scanner sc = new Scanner(System.in);
            int turns = 3 - i;
            System.out.println("Введите число от 0 до 9. У вас осталось попыток: " + turns);
            int playerAnswer = sc.nextInt();
            if (playerAnswer == answer) {
                System.out.println("Вы угадали!");
                break;
            } else if (playerAnswer > answer) {
                System.out.println("Указанное число больше загаданного");
            } else if (playerAnswer < answer) {
                System.out.println("Указанное число меньше загаданного");
            }
        }
    }

    public static String AskUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваш ответ");
        String answer = sc.nextLine();
        answer = answer.toLowerCase();
        return answer;
    }

}

