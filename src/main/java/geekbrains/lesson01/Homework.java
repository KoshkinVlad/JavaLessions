package geekbrains.lesson01;

public class Homework {
    public static void main(String[] args){
        // обьявляем и сразу присваиваем
        byte byteVal=30;
        short shortVal=15867;
        float floatVal=15.85f;
        char charVal='F';
        char charVal2=52;
        char charVal3='\u2242';
        // объявляем, а потом присваеваем
        int intVal;
        intVal=14564561;
        long longVal;
        longVal = 14564561234L;
        double doubleVal;
        doubleVal=56.15614561;
        boolean booleanVar;
        booleanVar=5+8<=13;

    }
    // третий пункт ДЗ
    public static int Calculation (int a, int b, int c, int d) {
        return a * (b + (c / d));
    }
    // четвёртый пункт ДЗ
    public static boolean IsCorrectSum(int a, int b){
        if (a+b>=10 && a+b<=20)
            return true;
        else return false;
    }
    // пятый пункт ДЗ
    public static void SayIfPositive(int a){
        if (a>=0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }
    // шестой пункт ДЗ
    public static boolean IsNegative (int a){
        if (a<0)
            return true;
        else
            return false;
    }
    // седьмой пункт ДЗ
    public static void HelloUser(String name){
        System.out.println("Привет, "+name+"!");
    }
    // восьмой пункт ДЗ
    public static void LeapYear(int year){
        if ((year%4==0 && year%100!=0) || year%400==0)
            System.out.println("Год високосный");
        else
            System.out.println("Год не високосный");
    }
}
