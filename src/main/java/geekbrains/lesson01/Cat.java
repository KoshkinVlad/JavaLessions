package geekbrains.lesson01;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        System.out.println("Появился кот " + name + ", он хочет есть, для сытости ему нужно " + appetite + " грамм еды!");
    }

    public void eat(Plate plate) {
        System.out.println(name + " собирается съесть из тарелки " + appetite + " грамм");
        satiety = plate.DecreaseFood(appetite);
        System.out.println(satiety ? name + " наелся!" : name + " всё ещё голоден...");
    }

}
