package geekbrains.lesson01;

public class Calculator {
    private double a, b;
    private char action;
    private double result;

    public double getResult() {
        return result;
    }

    public Calculator(double[] temp, char action) {
        this.a = temp[0];
        this.b = temp[1];
        this.action = action;
        switch (action) {
            case '+': {
                result=sum();
                break;
            }
            case '-': {
                result=substract();
                break;
            }
            case '*': {
                result=multiply();
                break;
            }
            case '/': {
                result=division();
                break;
            }
            case '%': {
                result=mod();
                break;
            }
        }
    }

    private double sum() {
        return a + b;
    }

    private double substract() {
        return a - b;
    }

    private double multiply() {
        return a * b;
    }

    private double division() throws ArithmeticException {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            return (a * b > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        }
    }

    private double mod() throws ArithmeticException {
        try {
            return a % b;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
