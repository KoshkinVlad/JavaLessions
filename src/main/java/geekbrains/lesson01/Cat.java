package geekbrains.lesson01;

public class Cat extends Animal {
    private final int maxRunValue=200;
    private static int amount;

    public Cat(String name) {
        super(name);
        super.maxRunValue=maxRunValue;
        amount++;
        System.out.println(". Это кот по имени "+name+", а всего котов у нас "+amount);
    }
    @Override
    public void Swim(int length) {
        System.out.println(name + " отказывается лезть в воду, поцарапал Вас и убежал прочь!");
    }
}
