package geekbrains.lesson01;

public class Employeer {
    private String name, position, email, phone;
    private int salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Employeer(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void PrintInfo() {
        System.out.println("Name is " + name + ", " + age + " years old. Position is " + position + ".\nE-mail: " + email + ", phone: " + phone + "\nSalary: " + salary + "Rub");
    }
}
