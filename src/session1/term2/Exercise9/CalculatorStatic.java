package session1.term2.Exercise9;

public class CalculatorStatic {

    public static double number1;
    public static double number2;

    public CalculatorStatic(double number1, double number2){
        CalculatorStatic.number1 = number1;
        CalculatorStatic.number2 = number2;
    }

    public static double add(){
        return number1 + number2;
    }

    public static double sustract(){
        return number1 - number2;
    }

    public static double multiply(){
        return number1 * number2;
    }

    public static double divide(){
        return number1 / number2;
    }
}

