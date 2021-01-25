package session1.term2.Exercise6;

import java.util.Scanner;

public class Inputs {
    Scanner input;

    public Inputs(Scanner input) {
        this.input = input;
    }

    public int getIntValue() {
        int value = input.nextInt();
        return value;
    }

    public double getDoubleValue() {
        double value = 0;
        do{
            System.out.println("Introduce la velocidad:");
            if (input.hasNextDouble()) {
                value = input.nextDouble();
            }else {
                input.next();
            }
        }while(value <= 0);

        return value;
    }
}
