package practice1.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner input;

    public Menu(Scanner input){
        this.input = input;
    }

    private int currentId = 0;
    ArrayList<Character> characters = new ArrayList<>();

    public void display() {
        int option = -1;
        do {
            System.out.println("¿Qué desea hacer? 1.Crear personajes. 2.Mostrar personajes. 3.Luchar. 4.Salir");
            if(input.hasNextInt()) {
                option = input.nextInt();
            }
            input.nextLine();
            switch (option) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    showCharacters();
                    break;
                case 3:
                    boolean hasFighter = false;
                    for (Character character : characters) {
                        if (character instanceof Fighter){
                            hasFighter = true;
                        }
                    }
                    if(characters.size() >= 2 && hasFighter ) {
                        figth();
                    } else {
                        System.out.println("Las luchas no están aún disponibles");
                    }

                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (option != 4);
    }

    public void createCharacter() {
        String name;
        do {
            System.out.println("Introduce el nombre");
            name = input.nextLine();
        } while (name.length() > 7);
        int option = -1;
        do {
            System.out.println("Selecciona el tipo de personaje");
            System.out.println("Personajes normales: 1.Humano. 2.Enano");
            System.out.println("Personajes luchadores: 3.Orco. 4.Troll");
            if(input.hasNextInt()) {
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    characters.add(new Human(currentId, name));
                    break;
                case 2:
                    characters.add(new Dwarf(currentId, name));
                    break;
                case 3:
                    characters.add(new Orc(currentId, name));
                    break;
                case 4:
                    characters.add(new Troll(currentId, name));
                    break;
            }
        } while (option < 1 || option > 4);
        currentId++;
    }

    public void showCharacters() {
        if (characters.isEmpty()) {
            System.out.println("No hay personajes creados");
        } else {
            for (Character character : characters) {
                System.out.println(character.toString());
            }
        }
    }

    public void figth() {
        int figtherIndex;
        for (Character character : characters) {
            if (character instanceof Fighter) {
                System.out.println(character.toString());
            }
        }
        do {
            System.out.println("Selecciona el id del luchador");
            figtherIndex = input.nextInt();
            input.nextLine();
            System.out.println(characters.get(figtherIndex) instanceof Fighter);
        }while((figtherIndex < 0 || figtherIndex >= characters.size()) || !(characters.get(figtherIndex)
                instanceof Fighter));

        int oponentIndex;
        for (Character character : characters) {
            if (character != characters.get(figtherIndex))
            System.out.println(character.toString());
        }
        do {
            System.out.println("Selecciona el id del oponente");
            oponentIndex = input.nextInt();
            input.nextLine();
        }while((oponentIndex < 0 || oponentIndex >= characters.size()) && oponentIndex == figtherIndex);
        Character fighter = characters.get(figtherIndex);
        Character oponent = characters.get(oponentIndex);

        Character winner = ((Fighter) fighter).figth(oponent);
        if(winner == fighter) {
            System.out.println(fighter.name+" gana a "+ oponent.name);
        } else {
            System.out.println(fighter.name+" pierde contra "+ oponent.name);
        }
    }


}
