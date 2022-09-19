import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class COIN {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        while (true) {


            List<String> expressionList = new ArrayList<>();
            while (true) {
                String line = n.nextLine();
                if (!Objects.equals(line, "-run")) {
                    expressionList.add(line);
                } else {
                    break;
                }
            }
            try {

                StringBuilder expression = new StringBuilder();
                StringBuilder answer = new StringBuilder();

                for (String value : expressionList) {
                    if (value.startsWith("print(") && value.endsWith(")")) {
                        answer.append(Computing.print(value));
                    }
                    if (value.startsWith("math(") && value.endsWith(")")) {
                        answer.append(Computing.mathCompute(value)).append("\n");
                    }
                    if (value.startsWith("add(") && value.endsWith(")")) {
                        answer.append(Computing.addTwoArgs(value)).append("\n");
                    }
                    if (value.startsWith("sub(") && value.endsWith(")")) {
                        answer.append(Computing.subTwoArgs(value)).append("\n");
                    }
                    if (value.startsWith("mul(") && value.endsWith(")")) {
                        answer.append(Computing.mulTwoArgs(value)).append("\n");
                    }
                    if (value.startsWith("add(") && value.endsWith(")")) {
                        answer.append(Computing.divTwoArgs(value)).append("\n");
                    }
                }


                for (String s : expressionList) {
                    expression.append(s);
                }
                char[] everyCharOfCode = expression.toString().toCharArray();
                String secretNumber = "";
                for (int i = 0; i < everyCharOfCode.length; i++) {
                    int currentNumber = everyCharOfCode[i];
                    secretNumber += Math.pow(currentNumber, 7);
                }
                secretNumber = secretNumber.replace(".", "");
                secretNumber = secretNumber.replace("E", "");

                //String is ready. It contains tokens,starting with ~
                System.out.println("secret number is: " + secretNumber);
                System.out.println("length : " + secretNumber.length());

                Secret.setSecretNumber(secretNumber + secretNumber);

                RectanglesDrawingExample.main();
                //Answer consists all computing of available functions
                System.out.println("answer is: " + answer);
            } catch (Exception e) {
                System.out.println("Error!");
            }

        }

    }
}
