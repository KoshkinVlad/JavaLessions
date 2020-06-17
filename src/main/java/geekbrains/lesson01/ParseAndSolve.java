package geekbrains.lesson01;

public class ParseAndSolve {
    private static char action;
    private static final char[] ACTIONS = {'+', '-', '*', '/', '%',};

    public static char getAction() {
        return action;
    }

    public static double[] Parse(String equation) {
        // например:equation="        25.0 +   459.65     "
        equation = equation.replace(" ", ""); // убираем все пробелы из строки
        //equation="25.0+459.65"
        int actionIndex = -1;
        for (int i = 0; i < equation.length(); i++) {
            // ищем действие в строке
            for (char act : ACTIONS) {
                if (equation.charAt(i) == act) {
                    action = act;
                    actionIndex = i;
                    break;
                }
            }
        }
        // теперь action='+'
        // ищем операнды
        double[] res = {Double.parseDouble(equation.substring(0, actionIndex)), Double.parseDouble(equation.substring(actionIndex+1,equation.length()))};
        return res;


    }
}
