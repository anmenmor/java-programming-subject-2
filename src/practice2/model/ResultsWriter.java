package practice2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsWriter {

    public void writeInFile(String message) throws IOException {
        try (FileWriter writer = new FileWriter("src/practice2/resources/files/result.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(message);
            bw.newLine();
        } catch (IOException exception) {
            System.out.println("Error writing in the file");
        }
    }
}
