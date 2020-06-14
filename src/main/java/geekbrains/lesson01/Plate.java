package geekbrains.lesson01;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Еды в ёмкости : " + food + " грамм");
    }

    public boolean DecreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            System.out.println("Еды не хватило, кот не захотел даже начинать есть!");
            return false;
        }
    }

    public void AddFood(int n) {
        System.out.print("Вы подсыпали в ёмкость " + n + " грамм еды!");
        food += n;
        System.out.println("Теперь в ёмкости " + food + " грамм!");
    }
}
