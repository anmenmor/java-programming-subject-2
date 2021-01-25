package session1.term1.Exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] catalog = {"Los muertos vivientes", "Brevisima historia del tiempo", "La clave secreta del universo",
                "Mi universo", "Patria", "De mayor quiero ser feliz", "empieza por tus zapatos"};

        System.out.println("¿Qué libro quieres consultar?");
        Scanner input = new Scanner(System.in);
        String book = input.nextLine();
        boolean exit = false;

        for (int i = 0; i < catalog.length; i++) {
            if (book.equalsIgnoreCase(catalog[i])) {
                exit = true;
            }
        }
        if (exit) {
            System.out.println("Se ha localizado el libro");
        } else {
            System.out.println("No se ha localizado el libro");
        }
    }
}

