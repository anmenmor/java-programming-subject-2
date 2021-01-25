package practice2.model;

import java.util.ArrayList;
import java.util.Map;

public class CharactersManager {


    private ArrayList<String> fightersNames = new ArrayList<>();
    private ArrayList<String> charactersNames = new ArrayList<>();
    private Map<String, Character> characters;

    public CharactersManager() {
        FilesReader reader = new FilesReader();
        characters = reader.readCharactersFile();
        for (Character character : characters.values()) {
            charactersNames.add(character.getNom());
            if (character instanceof Fighter) {
                fightersNames.add(character.getNom());
            }
        }
    }

    public ArrayList<String> getFightersNames() {
        return fightersNames;
    }

    public ArrayList<String> getCharactersNames() {
        return charactersNames;
    }

    public Map<String, Character> getCharacters() {
        return characters;
    }
}