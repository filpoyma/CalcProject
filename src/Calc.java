import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rom on 22.05.2018.
 */
public class Calc {
    public static double calc(String expression){
        int i         = 0;
        double result = 0;

        String reg_exp_digital   = "[0-9]+";
        String reg_exp_operation = "[\\*\\/\\+\\-%^]";
        expression = expression.replaceAll("\\s", "");
        Pattern dig_pattern = Pattern.compile(reg_exp_digital);
        Pattern op_pattern = Pattern.compile(reg_exp_operation);
        Matcher dig_matcher = dig_pattern.matcher(expression);
        Matcher op_matcher = op_pattern.matcher(expression);

        while (dig_matcher.find()) i++;
        double[] digit = new double[i];
        String[] oper = new String[i - 1];
        dig_matcher.reset();

        for (i = 0; dig_matcher.find(); i++) {
            digit[i] = Double.parseDouble(dig_matcher.group());
            System.out.println(digit[i]);
        }
        for (i = 0; op_matcher.find(); i++) {
            oper[i] = op_matcher.group();
            System.out.println(oper[i]);
            result = Act.act(digit[i], digit[i + 1], oper[i]);
            digit[i+1] = result;
        }
        return result;
    }
}
