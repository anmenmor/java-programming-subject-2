package session1.term2.Exercise7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactManager myContactManager = new ContactManager();

        System.out.println("Bienvenido a ContactsManager.");
        int option;
        do{
            System.out.println("Escoge una opción: 1.Añadir nuevo contacto. 2.Buscar conntacto. 3.Salir");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1: {
                    System.out.println("Introduzca el nombre");
                    String name = input.nextLine();
                    System.out.println("Introduzca el telefono");
                    String phone = input.nextLine();
                    System.out.println("Introduzca el email");
                    String email = input.nextLine();
                    Contact contact = new Contact(name, phone, email);
                    myContactManager.addNewContact(contact);
                    break;
                }
                case 2: {
                    System.out.println("Introduzca el nombre");
                    String name = input.nextLine();
                    myContactManager.seekContact(name);
                    break;
                }
                case 3:
                    break;
            }
        } while (option != 3);

        for(int i = 0; i < myContactManager.getContacts().size(); i++){
            System.out.println(myContactManager.getContacts().get(i));
        }


    }
}
