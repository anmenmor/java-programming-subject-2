package session5.exercise2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import sun.jvm.hotspot.debugger.MachineDescriptionPPC;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String fileName = "src/session5/exercise2/people.txt";
        String fileName2 = "src/session5/exercise2/people.xml";
        Path path = Paths.get(fileName);
        Path path2 = Paths.get(fileName2);
        List<String> lines = readFromFile(path);
        writeInXmlFile(lines, path2);
    }

    public static List<String> readFromFile(Path path) {
        List<String> lines = Collections.emptyList();
        try {
             lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            System.out.println("Error");
        }
        return lines;
    }

    public static void writeInXmlFile(List<String> lines, Path path) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("people");
        document.appendChild(root);
        for (String linea : lines) {
            String[] values = linea.split(" ");
            Element person = document.createElement("person");
            root.appendChild(person);
            Element elementName = document.createElement("name");
            elementName.setTextContent(values[0]);
            person.appendChild(elementName);
            Element elementSurname = document.createElement("surname");
            elementSurname.setTextContent(values[1]);
            person.appendChild(elementSurname);
            Element elementBirthdate = document.createElement("birthdate");
            elementBirthdate.setTextContent(values[2]);
            person.appendChild(elementBirthdate);
            Element elementSex = document.createElement("sex");
            elementSex.setTextContent(values[3]);
            person.appendChild(elementSex);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult  streamResult = new StreamResult(path.toFile());
        transformer.transform(domSource, streamResult);
        System.out.println("Done");

    }

}
