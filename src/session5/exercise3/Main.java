package session5.exercise3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Ref;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/session5/exercise3/stockTextFile.txt";
        Path path = Paths.get(fileName);
        String fileName2 = "src/session5/exercise3/stockTextFile2.txt";
        Path path2 = Paths.get(fileName2);
        List<String> lines = readFromFile(path);
        writeInFile(lines, path2);
    }

    public static List<String> readFromFile(Path path) throws IOException {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            System.out.println("Error");
            throw exception;
        }
        return lines;
    }

    public static void writeInFile(List<String> lines, Path path) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        for (String linea : lines) {
            String[] values = linea.split(";");
            if (!values[0].equals("TF103C-1A040A")) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }
}