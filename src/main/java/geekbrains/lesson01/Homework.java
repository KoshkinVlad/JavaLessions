package geekbrains.lesson01;

import java.util.Random;

public class Homework {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 0, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }

        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 3 * i;
        }

        int[] arr3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6)
                arr3[i] *= 2;
        }

        int[][] arr4 = new int[5][5];
        // поскольку мы имеем дело с диагональными элементами, можно обойтись одним циклом
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
        }

        int[] arr5 = new int[10];
        Random r = new Random(); // чтобы заполнить массив случайными числами
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = r.nextInt();
        }
        int min = arr5[0];
        int max = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min)
                min = arr5[i];
            if (arr5[i] > max)
                max = arr5[i];
        }
    }

}
