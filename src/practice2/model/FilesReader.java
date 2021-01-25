package practice2.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FilesReader {

    public ArrayList<User> readUsersFile() {
        ArrayList<User> users = new ArrayList<>();
        String fileName = "./src/practice2/resources/files/users.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            System.out.println("Error");
            exception.printStackTrace();
        }
        for (String linea : lines) {
            String[] values;
            values = linea.split(":");
            User user = new User(values[0], values[1]);
            users.add(user);
        }
        return users;
    }

    public Map<String, Character> readCharactersFile() {
        Map<String, Character> characters = new HashMap<>();
        String fileName = "./src/practice2/resources/files/characters.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            System.out.println("Error");
            exception.printStackTrace();
        }
        for (String linea : lines) {
            String[] values;
            values = linea.split(":");
            switch (values[1]) {
                case "Human":
                    characters.put(values[0], new Human(values[0]));
                    break;
                case "Nan":
                    characters.put(values[0], new Nan(values[0]));
                    break;
                case "Orc":
                    characters.put(values[0], new Orc(values[0]));
                    break;
                case "Troll":
                    characters.put(values[0], new Troll(values[0]));
                    break;
            }
        }
        return characters;
    }
}
