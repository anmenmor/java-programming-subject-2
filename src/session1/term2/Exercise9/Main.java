package session1.term2.Exercise9;

public class Main {

    public static void main(String[] args) {

        CalculatorStatic.number1 = 1;
        CalculatorStatic.number2 = 2;
        System.out.println(CalculatorStatic.add());
        System.out.println(CalculatorStatic.sustract());
        System.out.println(CalculatorStatic.multiply());
        System.out.println(CalculatorStatic.divide());

        CalculatorNonStatic calculator = new CalculatorNonStatic(3,5);
        System.out.println(calculator.add());
        System.out.println(calculator.sustract());
        System.out.println(calculator.multiply());
        System.out.println(calculator.divide());
    }

}
