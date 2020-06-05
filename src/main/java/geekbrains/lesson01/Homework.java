package geekbrains.lesson01;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class Homework {
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int FIELD_SIZE = 3;
    public static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        clrScr();
        InitField();
        PrintField();
        while (true) {
            humanTurn();
            if (isWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isFieldFill()) {
                System.out.println("Ничья");
                break;
            }
            clrScr();
            aiTurn();
            if (isWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isFieldFill()) {
                System.out.println("Ничья");
                break;
            }

        }
        System.out.println("Игра закончена");
        sc.close();
    }

    private static void clrScr() {
        for(int i=0;i<500;i++) {
            System.out.print("\n");
        }
    }

    private static boolean isFieldFill() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int k = 0; k < FIELD_SIZE; k++) {
                if (field[i][k] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void InitField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int k = 0; k < FIELD_SIZE; k++) {
                field[i][k] = DOT_EMPTY;
            }
        }
    }

    private static void PrintField() {
        System.out.print("0 ");
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int k = 0; k < FIELD_SIZE; k++) {
                System.out.print(field[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isWin(char symb) {
        boolean isWin = true;
        // проход по строчкам
        for (int i = 0; i < FIELD_SIZE; i++) {
            isWin = true; // предполагаем, что в строке есть победа
            for (int k = 0; k < FIELD_SIZE - 1; k++) {
                if (field[i][k] != field[i][k + 1]) { // если соседние ячейки строки не равны, то победы нет и переходим на след. строчку
                    isWin = false;
                    break;
                } else if (field[i][k] != symb) { // если элемент строчки не является переданным символом, тоже нет победы и идём далее
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin; // если после двух проверок флаг не поменялся, значит, есть победа и дальше уже можно не проверять
        }
        // проход по столбцам
        for (int i = 0; i < FIELD_SIZE; i++) {
            isWin = true; // предполагаем, что в столбце есть победа
            for (int k = 0; k < FIELD_SIZE - 1; k++) {
                if (field[k][i] != field[k + 1][i]) { // если соседние ячейки столбца не равны, то победы нет и переходим на след. строчку
                    isWin = false;
                    break;
                } else if (field[k][i] != symb) { // если элемент строчки не является переданным символом, тоже нет победы и идём далее
                    isWin = false;
                    break;
                }
            }
            if (isWin)
                return isWin; // если после двух проверок флаг не поменялся, значит, есть победа и дальше уже можно не проверять
        }
        // проход по главной диагонали
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            isWin = true; // предполагаем, что в диагонали есть победа
            if (field[i][i] != field[i + 1][i + 1]) { // если соседние ячейки диагонали не равны, то победы нет и переходим на след. строчку
                isWin = false;
                break;
            } else if (field[i][i] != symb) { // если элемент диагонали не является переданным символом, тоже нет победыи идём далее
                isWin = false;
                break;
            }
        }
        if (isWin)
            return isWin; // если после двух проверок флаг не поменялся, значит, есть победа и дальше уже можно не проверять
        // проход по побочной диагонали
        for (int i = 0; i < FIELD_SIZE - 1; i++) {
            isWin = true; // предполагаем, что в диагонали есть победа
            if (field[i][FIELD_SIZE - 1 - i] != field[i + 1][FIELD_SIZE - 1 - i - 1]) { // если соседние ячейки диагонали не равны, то победы нет и переходим на след. строчку
                isWin = false;
                break;
            } else if (field[i][FIELD_SIZE - 1 - i] != symb) { // если элемент диагонали не является переданным символом, тоже нет победыи идём далее
                isWin = false;
                break;
            }
        }
        return isWin;
    }

    private static void humanTurn() {
        int x = 0, y = 0;
        do {
            System.out.print("Введите координаты, куда поставить крестик, в формате X Y: ");
            y = sc.nextInt();
            x = sc.nextInt();
        }
        while (!isValidCell(x, y));
        placeSymbol(x, y, DOT_X);
        PrintField();
    }

    private static void aiTurn() {
        Random rand = new Random();
        int x, y;
        x = coordsToBlock()[0];
        y = coordsToBlock()[1];
        System.out.println("Ход компьютера на точку " + (y) + " " + (x));
        placeSymbol(x, y, DOT_O);
        PrintField();
    }

    private static int[] coordsToBlock() {
        int amount = 0;// количество символов противника (DOT_X) в проверяемом диапазоне
        // проход по строкам
        for (int i = 0; i < FIELD_SIZE; i++) {
            amount = 0;
            for (int k = 0; k < FIELD_SIZE; k++) {
                if (field[i][k] == DOT_X)
                    amount++;
            }
            // если 2 из 3 ячеек в диапазоне заполнены символом противника, а одна пустая, надо заблокировать оставшуюся ячейку
            if (amount == FIELD_SIZE - 1) {
                for (int k = 0; k < FIELD_SIZE; k++) { // ищем пустую ячейку и блокируем
                    if (field[i][k] == DOT_EMPTY) {
                        return new int[]{i + 1, k + 1};
                    }
                }
            }
        }
        // проход по столбцам
        for (int i = 0; i < FIELD_SIZE; i++) {
            amount = 0;
            for (int k = 0; k < FIELD_SIZE; k++) {
                if (field[k][i] == DOT_X)
                    amount++;
            }
            // если 2 из 3 ячеек в диапазоне заполнены символом противника, надо заблокировать оставшуюся ячейку
            if (amount == FIELD_SIZE - 1) {
                for (int k = 0; k < FIELD_SIZE; k++) { // ищем пустую ячейку и блокируем
                    if (field[k][i] == DOT_EMPTY) {
                        return new int[]{k + 1, i + 1};
                    }
                }
            }
        }
        // проход по главной диагонали
        amount = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {

            if (field[i][i] == DOT_X)
                amount++;
        }
        if (amount == FIELD_SIZE - 1) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (field[i][i] == DOT_EMPTY) {
                    return new int[]{i + 1, i + 1};
                }
            }
        }
        // проход по побочной диагонали
        amount = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[FIELD_SIZE - i - 1][i] == DOT_X)
                amount++;
        }
        if (amount == FIELD_SIZE - 1) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (field[FIELD_SIZE - i - 1][i] == DOT_EMPTY) {
                    return new int[]{FIELD_SIZE - i, i + 1};
                }
            }
        }
        // если не надо ничего блокировать, просто ставим на случайное место нолик
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(3) + 1;
            y = rand.nextInt(3) + 1;
        }
        while (!isValidCell(x, y));
        return new int[]{x, y};
    }

    private static void placeSymbol(int x, int y, char symb) {
        field[x - 1][y - 1] = symb;
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 1 || x > FIELD_SIZE || y < 1 || y > FIELD_SIZE) {
            return false;
        } else if (field[x-1][y-1] != DOT_EMPTY) {
            return false;
        }
        return true;
    }
}
