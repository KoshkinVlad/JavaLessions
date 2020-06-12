package geekbrains.lesson01;

public class Animal {
    protected String name;
    protected int maxRunValue;
    protected int maxSwimValue;
    private final int maxJumpValue=2;
    private static int amount;

    public Animal(String name) {
        this.name = name;
        amount++;
        System.out.print("Создано животное №" + amount);
    }

    public void Run(int length) {
        System.out.println(length <= maxRunValue ? name + " пробежал " + length + " метров" : name + " пробежал " + maxRunValue + " метров, устал и упал");
    }

    public void Swim(int length) {
        System.out.println(length <= maxSwimValue ? name + " проплыл " + length + " метров" : name + " проплыл " + maxRunValue + " метров, устал и лёг на воду");
    }

    public void Jump(int height) {
        System.out.println(height <= maxJumpValue ? name + " подпрыгнул на " + height + " метр" : name + " подпрыгнул на " + maxJumpValue + " метра, а выше никак");
    }
}
