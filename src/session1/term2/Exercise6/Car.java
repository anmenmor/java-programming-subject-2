package session1.term2.Exercise6;

import java.util.Scanner;

public class Car {

    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void accelerate(double accelerateSpeed) {
        speed += accelerateSpeed;
    }

    public void slowDown(double breakSpeed) {
        if (breakSpeed < speed) {
            speed -= breakSpeed;
        }
    }

}
