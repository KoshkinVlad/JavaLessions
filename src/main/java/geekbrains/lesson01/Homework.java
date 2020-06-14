package geekbrains.lesson01;

import java.util.Random;

public class Homework {
    public static void main(String[] args) {
//        Cat Vasya = new Cat("Васька", 50);
//        Plate plate = new Plate(30);
//        plate.info();
//        Vasya.eat(plate);
//        plate.info();
//        Cat Tom = new Cat("Том", 60);
//        Plate stewpot = new Plate(100);
//        stewpot.info();
//        Tom.eat(stewpot);
//        stewpot.info();

        // Пятый пункт
        Plate veryBigPot = new Plate(500);
        Cat[] cats = new Cat[10];
        Random rand = new Random();
        String[] catNames = new String[]{"Пушистик", "Мотька", "Мурка", "Джек", "Петька", "Алиска", "Андрейка", "Ксюша", "Киска", "Обжора"};
        for (int i = 0; i < cats.length; i++) {
            int appetite =rand.nextInt(150);
            cats[i]=new Cat(catNames[i],appetite);
            veryBigPot.info();
            cats[i].eat(veryBigPot);
            veryBigPot.info();
            veryBigPot.AddFood(rand.nextInt(10));
        }

    }
}