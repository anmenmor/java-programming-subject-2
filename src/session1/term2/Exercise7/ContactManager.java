package session1.term2.Exercise7;

import java.util.ArrayList;

public class ContactManager {

    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addNewContact(Contact contact) {
        boolean exit = false;
        if (contacts.isEmpty()) {
            contacts.add(contact);
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getName().equals(contact.getName())) {
                    exit = true;
                }
            }
            if (!exit) {
                contacts.add(contact);
            }
        }
    }

    public void seekContact(String name){
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                System.out.println(contacts.get(i));
            }else {
                System.out.println("El contacto no existe");
            }
        }
    }

    public ArrayList<Contact> getContacts () {
        return contacts;
    }
}