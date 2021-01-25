package session1.term1.Exercise4part2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] catalog = {"Los muertos vivientes", "Brevisima historia del tiempo", "La clave secreta del universo",
                "Mi universo", "Patria", "De mayor quiero ser feliz", "empieza por tus zapatos"};

        System.out.println("¿Escribe la palabra o palabras del libro que quieres buscar?");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].contains(word)){
                System.out.println(catalog[i]);
            }

    }
    }
}