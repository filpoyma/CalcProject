public class Act {
    public static double act(double a, double b, String opp){
        switch (opp)
        {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "%": return a % b;
            case "^": return Math.pow(a, b);
            default: {System.out.println("Неверная входная строка '{match.Value}'"); return 0;}
        }
    }
}