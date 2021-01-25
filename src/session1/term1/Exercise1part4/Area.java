package session1.term1.Exercise1part4;

import java.util.Scanner;

public class Area {
    public void showMenu(Scanner input){
        System.out.println("Bienvenido. Selecciona la figura.");
        System.out.println("Cuadrado");
        System.out.println("Triángulo");
        System.out.println("Círculo");
        System.out.println("Rombo");
        String figure = input.next();
        double area = 0;
        switch (figure.toLowerCase()) {
            case "cuadrado":
                double side = getValue(input, "lado");
                area = calculateSquareArea(side);
                break;
            case "triangulo":
                double base = getValue(input, "base");
                double heigth = getValue(input, "altura");
                area = calculateTriangleArea(base, heigth);
                break;
            case "circulo":
                double radio = getValue(input,"radio");
                area = calculateCircleArea(radio);
                break;
            case "rombo":
                double majorDiagonal = getValue(input, "diagonal mayor" );
                double minorDiagonal = getValue(input, "diagonal menor");
                area = calculateRhombusArea(majorDiagonal, minorDiagonal);
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
                System.exit(0);

        }
        System.out.println("El área es: "+area);
    }

    public double calculateSquareArea(double side){
        return Math.pow(side, 2);
    }

    public double calculateTriangleArea(double base, double heigth){
        return base * heigth / 2;
    }

    public double calculateCircleArea(double radio){
        return Math.PI * Math.pow(radio, 2);
    }

    public double calculateRhombusArea(double majorDiagonal, double minorDiagonal){
        return majorDiagonal * minorDiagonal / 2;
    }

    public double getValue(Scanner input, String message){
        double value = 0;
        do{
            System.out.println("La longitud de "+message+" cm: ");
            if(input.hasNextDouble()) {
                value = input.nextDouble();
            }else{
                input.next();
            }
        }while(value <= 0);

        return value;
    }
}
