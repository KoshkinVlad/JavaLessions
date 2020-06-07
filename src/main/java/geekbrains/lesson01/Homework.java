package geekbrains.lesson01;

public class Homework {
    public static void main(String[] args) {
        Employeer[] empArray=new Employeer[5];
        empArray[0]=new Employeer("Ivan Ivanov","Teamlead", "ivanov@outlook.com","+7-896-569-45-89",75000,55);
        empArray[1]=new Employeer("Vladislav Koshkin", "Performance Engineer", "kisa94@mail.ru", "+7-426-987-65-45", 40000, 25);
        empArray[2]=new Employeer("Alexey Pupkin", "Manager", "pupLexxxa@yandex.ru", "+7-562-497-65-45", 60000, 45);
        empArray[3]=new Employeer("Anna Novak", "Head Chief", "annetqa@vk.com", "+7-487-569-72-56", 250000,19);
        empArray[4]=new Employeer("Gleb Galenkin", "Bookkeeper", "hlest@yahoo.com", "+7-598-521-56-89", 3000, 18);
        for (Employeer e : empArray) {
            if (e.getAge()>40) {
                e.PrintInfo();
            }
        }
    }
}