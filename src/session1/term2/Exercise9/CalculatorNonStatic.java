package session1.term2.Exercise9;

public class CalculatorNonStatic {

    private double number1;
    private double number2;

    public CalculatorNonStatic(double number1, double number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public double add(){
        return number1 + number2;
    }

    public double sustract(){
        return number1 - number2;
    }

    public double multiply(){
        return number1 * number2;
    }

    public double divide(){
        return number1 / number2;
    }
}
