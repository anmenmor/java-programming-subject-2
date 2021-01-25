package session1.term1.Exercise1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido. Selecciona la figura.");
        System.out.println("Cuadrado");
        System.out.println("Triángulo");
        System.out.println("Círculo");
        System.out.println("Rombo");
        Scanner input = new Scanner(System.in);
        String figure = input.next();

        double area = 0;
        switch (figure.toLowerCase()) {
            case "cuadrado":
                double side = 0;
                do {
                    System.out.println("Longitud del lado cm: ");
                    if(input.hasNextDouble()) {
                        side = input.nextDouble();
                    } else{
                        input.next();
                    }
                } while (side <= 0 );
                area = Math.pow(side, 2);
                break;
            case "triangulo":
                double base = 0;
                double heigth = 0;
                do {
                    System.out.println("Longitud de la base cm: ");
                    if(input.hasNextDouble()){
                        base = input.nextDouble();
                    }else{
                        input.next();
                    }
                }while(base <= 0);
                do {
                    System.out.println("Longitud de la altura cm: ");
                    if(input.hasNextDouble()){
                        heigth = input.nextDouble();
                    }else{
                        input.next();
                    }
                }while(heigth <= 0);
                area = base * heigth / 2;
                break;
            case "circulo":
                double radio = 0;
                do {
                    System.out.println("Longitud del radio cm: ");
                    if(input.hasNextDouble()) {
                        radio = input.nextDouble();
                    }else{
                        input.next();
                    }
                }while(radio <= 0);
                area = Math.PI * Math.pow(radio, 2);
                break;
            case "rombo":
                double majorDiagonal = 0;
                double minorDiagonal = 0;
                do {
                    System.out.println("La longitud de la diagonal mayor cm: ");
                    if(input.hasNextDouble()) {
                        majorDiagonal = input.nextDouble();
                    }else{
                        input.next();
                    }
                }while(majorDiagonal <= 0);
                do {
                    System.out.println("La longitud de la diagonal menor cm: ");
                    if(input.hasNextDouble()) {
                        minorDiagonal = input.nextDouble();
                    }else{
                        input.next();
                    }
                }while(minorDiagonal <= 0);
                area = majorDiagonal * minorDiagonal / 2;
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
                System.exit(0);

        }
        System.out.println("El área es " + area);
    }
}

