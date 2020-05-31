package geekbrains.lesson01;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        GuessTheNumber();
        WordPicker();
    }

    public static void GuessTheNumber() {
        //        Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        //        При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        //        После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        Random rand = new Random();
        int maxTryCount = 3;
        int userNumber;
        int repeat = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Компьютер загадал случайное число от 0 до 9. Попробуй отгадать его. У тебя 3 попытки...");
            int randomNumber = rand.nextInt(10);
            boolean isWin = false;
            for (int currentTry = 1; currentTry <= maxTryCount; currentTry++) {
                System.out.print("Попытка номер " + currentTry + ".\nВведи число: ");
                userNumber = sc.nextInt();
                if (userNumber < randomNumber) {
                    System.out.println("Введённое число меньше загаданного");
                } else if (userNumber > randomNumber) {
                    System.out.println("Введённое число больше загаданного");
                } else {
                    System.out.println("Вы угадали число!");
                    isWin = true;
                    break;
                }
            }
            System.out.println(isWin ? "Вы победили!" : "Вы проиграли :( Правильное число: " + randomNumber);
            System.out.print("Повторить игру? 1 - да, 0 - нет : ");
            repeat = sc.nextInt();
            if (repeat == 0) break;
        }
        while (repeat == 1);
//        sc.close(); если закрыть сканер тут, во 2м методе вызывается исключение java.util.NoSuchElementException
    }

    public static void WordPicker() {
//        Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//                сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//                apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String rightWord = words[rand.nextInt(words.length)];
        System.out.println("Компьютер загадал одно из следующих слов: ");
        for (String s : words) {
            System.out.print(s + ", ");
        }
        System.out.println("\nПопробуй угадать, какое слово он загадал, а компьютер подскажет, какие буквы стоят на своих местах");
        String userWord;
        do {
            System.out.print("Ваше предположение: ");
            userWord = sc.next().toLowerCase();
            if (userWord.equals(rightWord)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                // надо из двух слов найти слово с минимальным количеством символов
                // чтобы в цикле не вылезти за пределы слова
                int min = userWord.length();
                if (min > rightWord.length()) {
                    min = rightWord.length();
                }
                String prompt = ""; // тут будет подсказка
                for (int i = 0; i < min; i++) {
                    if (rightWord.charAt(i) == userWord.charAt(i)) {
                        prompt += userWord.charAt(i);
                    } else {
                        prompt += "#";
                    }
                }
                // заполняем подсказку до 15 символов
                int symbolAmount = 15;
                for (int i = prompt.length(); i < symbolAmount; i++) {
                    prompt += "#";
                }
                System.out.println("Открыты буквы, если они есть: " + prompt);
            }
        }
        while (true);
        sc.close();
    }

}
