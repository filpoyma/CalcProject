import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rom on 21.05.2018.
 */
public class Calculator {
    public static void main(String[] args) {

        System.out.print("Enter expression: ");
        String expression = inputString();
        System.out.printf("Result %f", calc(expression));
    }

    public static String inputString() {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        return exp;
    }
    public static double calc(String exp){
        String reg_exp_digital   = "[0-9]+";
        String reg_exp_operation = "[\\*\\/\\+\\-%^]";

        Pattern dig_pattern = Pattern.compile(reg_exp_digital);
        Pattern op_pattern = Pattern.compile(reg_exp_operation);
        Matcher dig_matcher = dig_pattern.matcher(exp);
        Matcher op_matcher = op_pattern.matcher(exp);

        int digit_counter = 0;
        while (dig_matcher.find()) digit_counter++;
        double[] digit = new double[digit_counter];
        String[] oper = new String[digit_counter - 1];
        dig_matcher.reset();

        for (int i = 0; dig_matcher.find(); i++) {
            digit[i] = Double.parseDouble(dig_matcher.group());
            //System.out.println(digit[i]);
        }
        double result = 0;
        for (int i = 0; op_matcher.find(); i++) {
            oper[i] = op_matcher.group();
            result = act(digit[i], digit[i + 1], oper[i]);
            digit[i+1] = result;
            //System.out.println(oper[i]);

        }
        return result;
    }

    public static double act(double a, double b, String opp){
        switch (opp)
        {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "%": return a % b;
            case "^": return Math.pow(a, b);
            default:  System.err.printf("Неверная входная строка %s", opp);
                return -1;

        }
    }
}
