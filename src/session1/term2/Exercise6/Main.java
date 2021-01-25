package session1.term2.Exercise6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car();
        Inputs inputs = new Inputs(new Scanner(System.in));
        int option;
        System.out.println("Bienvenido al simulador de coche.");
        System.out.println("La velocidad actual es " + car1.getSpeed());
        do{
            System.out.println("¿Qué quieres hacer: 1. Acelerar, 2. Frenar, 3. Salir?");
            option = inputs.getIntValue();
            switch (option) {
                case 1:
                    double accelerateSpeed = inputs.getDoubleValue();
                    car1.accelerate(accelerateSpeed);
                    System.out.println("La velocidad actual es " + car1.getSpeed());
                    break;
                case 2:
                    double slowSpeed = inputs.getDoubleValue();
                    car1.slowDown(slowSpeed);
                    System.out.println("La velocidad actual es " + car1.getSpeed());
                    break;
                case 3:
                    break;
            }
        } while (option != 3);
    }


}
