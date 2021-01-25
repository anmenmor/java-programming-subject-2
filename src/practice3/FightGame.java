package practice3;

import practice3.model.Character;
import practice3.model.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FightGame {
    ArrayList<Character> personatges;
    Connection con;
    Scanner input = new Scanner(System.in);
    DBManager dbManager;


    public FightGame (Connection con) {
        this.con = con;
        dbManager = new DBManager(con);
        dbManager.createTables();
        personatges = dbManager.getCharacters();
    }

    public void menu() throws Exception {

        int opcion;
        do {
            System.out.println("Menu del juego ");
            System.out.println("¿Que desea hacer?");
            System.out.println("1.Crear personajes");
            System.out.println("2.Mostrar personajes");
            System.out.println("3.Luchar");
            System.out.println("4.Salir");
            opcion = getIntFromUser(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
            switch (opcion) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    showCharacters();
                    break;
                case 3:
                    performFight();
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
            }
        } while (opcion != 4);
    }

    private void createCharacter() throws Exception {
        String nom ="";
        do {
            System.out.println("Escribe el nombre (máximo 7 caracteres):");
            nom = input.nextLine();
        }while(nom.length()>7 || dbManager.nameExists(nom));

        System.out.println("Selecciona tipos de personaje:");
        System.out.println("****Personajes Normales******");
        System.out.println("1.Humano");
        System.out.println("2.Enano");
        System.out.println("****Personajes Luchadores****");
        System.out.println("3.Orco");
        System.out.println("4.Troll");
        switch (getIntFromUser(new ArrayList<Integer>( Arrays.asList(1,2,3,4)))) {
            case 1:
                Character human = new Human(nom);
                personatges.add(human);
                dbManager.createCharacter(human, "Human");
                break;
            case 2:
                Character nan = new Nan(nom);
                personatges.add(nan);
                dbManager.createCharacter(nan, "Nan");
                break;
            case 3:
                Character orc = new Orc(nom);
                personatges.add(orc);
                dbManager.createCharacter(orc, "Orc");
                dbManager.createFightingResult(orc);
                break;
            case 4:
                Character troll = new Troll(nom);
                personatges.add(troll);
                dbManager.createCharacter(troll, "Troll");
                dbManager.createFightingResult(troll);
                break;
        }
    }

    private void showCharacters() {
        for (Character character : personatges) {
            System.out.println(character);
        }
    }

    private void performFight() throws Exception {
        ArrayList<Integer> valorsCorrectes = new ArrayList<>();
        System.out.println("Selecciona el id del luchador");
        for (Character character : personatges) {
            if (character instanceof Fighter && character.getLives() > 0) {
                System.out.println(character);
                valorsCorrectes.add(character.getId());
            }
        }
        Fighter lluitador = (Fighter) personatges.get(getIntFromUser(valorsCorrectes)-1);
        valorsCorrectes.clear();
        System.out.println("Selecciona el oponente:");
        for (Character character : personatges) {
            if (character.getLives() > 0 && character.getId() != lluitador.getId()) {
                System.out.println(character);
                valorsCorrectes.add(character.getId());
            }
        }
        Character oponent = personatges.get(getIntFromUser(valorsCorrectes)-1);

        if (lluitador.fight(oponent)) {
            System.out.println(String.format("%s gana a %s.", lluitador.getNom(), oponent.getNom()));
            lluitador.win();
            dbManager.registerFights(lluitador, oponent);
            dbManager.updateFightingResults(lluitador);
            if(oponent instanceof Fighter) {
                ((Fighter) oponent).lose();
                dbManager.updateFightingResults((Fighter) oponent);
            }
            else{
                oponent.loseLive();
            }
            dbManager.updateLives(oponent);
            if (oponent.getLives() == 0) {
                dbManager.deleteCharacter(oponent);
                personatges.remove(oponent.getId()-1);
                Character.setCharacterCounter(1);
                personatges = dbManager.getCharacters();
            }
        }
        else {
            System.out.println(String.format("%s pierde contra %s.", lluitador.getNom(), oponent.getNom()));
            lluitador.lose();
            dbManager.registerFights(oponent, lluitador);
            dbManager.updateLives(lluitador);
            dbManager.updateFightingResults(lluitador);
            if (lluitador.getLives() == 0) {
                dbManager.deleteCharacter(lluitador);
                personatges.remove(lluitador.getId()-1);
                Character.setCharacterCounter(1);
                personatges = dbManager.getCharacters();
            }
            if(oponent instanceof Fighter) {
                ((Fighter) oponent).win();
                dbManager.updateFightingResults((Fighter)oponent);}
        }
    }

    public int getIntFromUser(ArrayList<Integer> valorsValids){
        Scanner read = new Scanner(System.in);
        int variableRetorn = 0;

        boolean valorCorrecte = false;

        do{
            if (!read.hasNextInt()) {
                System.out.print("Selecciona un valor correcto:");
                System.out.println(valorsValids);
                read.nextLine();
            }
            else {
                variableRetorn = read.nextInt();

                if (valorsValids.contains(variableRetorn)) {
                    valorCorrecte = true;
                }
                else{
                    System.out.print("Selecciona un valor correcto:");
                    System.out.println(valorsValids);
                }

                read.nextLine();
            }

        }while(!valorCorrecte);

        return variableRetorn;
    }
}