
public class Computing {

    public static double mathCompute(String s) {
        s = s.substring(5, s.length() - 1);
        char[] expression = s.toCharArray();
        int firstArg;


        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < expression.length; i++) {

            //Char is a number
            switch (expression[i]) {
                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> currentNumber.append(expression[i]);
            }
            //char is +
            if (expression[i] == '+') {
                firstArg = Integer.parseInt(String.valueOf(currentNumber));
                return add(firstArg, expression, i);

            }
            //char is -
            if (expression[i] == '-') {
                firstArg = Integer.parseInt(String.valueOf(currentNumber));
                return sub(firstArg, expression, i);
            }
            //char is *
            if (expression[i] == '*') {
                firstArg = Integer.parseInt(String.valueOf(currentNumber));
                return mul(firstArg, expression, i);
            }
            //char is /
            if (expression[i] == '/') {
                firstArg = Integer.parseInt(String.valueOf(currentNumber));
                return div(firstArg, expression, i);
            }
        }

        return -1;
    }

    private static double add(double firstArg, char[] expression, int i) {
        StringBuilder currentNumber = new StringBuilder();
        for (int j = i + 1; j < expression.length; j++) {
            currentNumber.append(expression[j]);
        }
        return firstArg + Integer.parseInt(String.valueOf(currentNumber));
    }

    private static double sub(double firstArg, char[] expression, int i) {
        StringBuilder currentNumber = new StringBuilder();
        for (int j = i + 1; j < expression.length; j++) {
            currentNumber.append(expression[j]);
        }
        return firstArg - Integer.parseInt(String.valueOf(currentNumber));
    }

    private static double mul(double firstArg, char[] expression, int i) {
        StringBuilder currentNumber = new StringBuilder();
        for (int j = i + 1; j < expression.length; j++) {
            currentNumber.append(expression[j]);
        }
        return firstArg * Integer.parseInt(String.valueOf(currentNumber));
    }

    private static double div(double firstArg, char[] expression, int i) {
        StringBuilder currentNumber = new StringBuilder();
        for (int j = i + 1; j < expression.length; j++) {
            currentNumber.append(expression[j]);
        }
        return firstArg / Integer.parseInt(String.valueOf(currentNumber));
    }

    public static String print(String s) {
        return s.substring(6, s.length() - 1);
    }

    public static double addTwoArgs(String s) {
        s = s.substring(4,s.length()-1);
        String[] a = s.split(",");
        return Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
    }

    public static double subTwoArgs(String s) {
        s = s.substring(4,s.length()-1);
        String[] a = s.split(",");
        return Integer.parseInt(a[0]) - Integer.parseInt(a[1]);
    }

    public static double mulTwoArgs(String s) {
        s = s.substring(4,s.length()-1);
        String[] a = s.split(",");
        return Integer.parseInt(a[0]) * Integer.parseInt(a[1]);
    }

    public static double divTwoArgs(String s) {
        s = s.substring(4,s.length()-1);
        String[] a = s.split(",");
        return Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
    }
}
