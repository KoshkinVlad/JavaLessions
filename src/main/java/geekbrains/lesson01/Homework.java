package geekbrains.lesson01;

public class Homework {
    public static void main(String[] args) {
        Cat vasya=new Cat("Васька");
        vasya.Swim(5);
        vasya.Jump(1);
        vasya.Run(500);

        Dog bobik=new Dog("Бобик");
        bobik.Swim(5);
        bobik.Swim(15);
        bobik.Jump(1);
        bobik.Jump(3);
        bobik.Run(450);
        bobik.Run(600);

        Cat murka=new Cat("Мурка");
        murka.Jump(3);
        murka.Run(150);
    }
}