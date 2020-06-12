package geekbrains.lesson01;

public class Dog extends Animal {
    private final int maxRunValue=500;
    private final  int maxSwimValue=10;
    private static int amount;

    public Dog(String name) {
        super(name);
        super.maxRunValue=maxRunValue;
        super.maxSwimValue=maxSwimValue;
        amount++;
        System.out.println(". Это пёс по имени "+name+", а всего собак у нас "+amount);
    }
}
