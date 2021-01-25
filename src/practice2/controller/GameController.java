package practice2.controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import practice2.model.*;
import practice2.model.Character;
import java.io.*;
import java.util.Map;

public class GameController {
    @FXML
    public ComboBox<String> fighterSelected;
    @FXML
    public ComboBox<String> oponentSelected;
    @FXML
    public Button resetButton;
    @FXML
    public Button figthButton;
    @FXML
    public ImageView fighterImage;
    @FXML
    public ImageView oponentImage;
    @FXML
    public Label messageLabel;

    CharactersManager charactersManager = new CharactersManager();
    ResultsWriter resultsWriter = new ResultsWriter();
    String fighterName = "";
    String oponentName = "";
    String message;

    public void initialize() throws FileNotFoundException {
        ObservableList<String> fightersList = fighterSelected.getItems();
        fightersList.addAll(charactersManager.getFightersNames());
        ObservableList<String> oponentsList = oponentSelected.getItems();
        oponentsList.addAll(charactersManager.getCharactersNames());
        InputStream stream = new FileInputStream("src/practice2/resources/images/noImage.png");
        Image image = new Image(stream);
        fighterImage.setImage(image);
        oponentImage.setImage(image);
    }

    public void chooseFighter(ActionEvent event) throws IOException {
        try {
            if (fighterSelected.getSelectionModel().getSelectedItem() != null) {
                fighterName = fighterSelected.getSelectionModel().getSelectedItem();
                if (fighterName.equals(oponentName)) {
                    throw new NoSelectableCharacterException();
                }
            } else {
                fighterName = "";
            }

            InputStream stream;
            switch (fighterName) {
                case "Frederic":
                    stream = new FileInputStream("src/practice2/resources/images/Frederic.png");
                    break;
                case "Lara":
                    stream = new FileInputStream("src/practice2/resources/images/Lara.png");
                    break;
                case "Alexander":
                    stream = new FileInputStream("src/practice2/resources/images/Alexander.png");
                    break;
                case "Joane":
                    stream = new FileInputStream("src/practice2/resources/images/Joane.png");
                    break;
                default:
                    stream = new FileInputStream("src/practice2/resources/images/noImage.png");
            }
            Image image = new Image(stream);
            fighterImage.setImage(image);
            if (!fighterName.isEmpty() && !oponentName.isEmpty()) {
                figthButton.setDisable(false);
                fighterImage.setOpacity(1);
                oponentImage.setOpacity(1);
            }
        } catch (NoSelectableCharacterException e) {
            Stage stage = new Stage();
            stage.setTitle("Error Window");
            Label label = new Label("Debe seleccionar otro personaje");
            Scene scene = new Scene(label, 400, 50);
            stage.setScene(scene);
            stage.show();
            figthButton.setDisable(true);
            fighterSelected.valueProperty().set(null);
        }
    }

    public void chooseOponent(ActionEvent event) throws IOException {
        try {
            if (oponentSelected.getSelectionModel().getSelectedItem() != null) {
                oponentName = oponentSelected.getSelectionModel().getSelectedItem();
                if (oponentName.equals(fighterName)) {
                    throw new NoSelectableCharacterException();
                }
            } else {
                oponentName = "";
            }
            InputStream stream;
            switch (oponentName) {
                case "Frederic":
                    stream = new FileInputStream("src/practice2/resources/images/Frederic.png");
                    break;
                case "Lara":
                    stream = new FileInputStream("src/practice2/resources/images/Lara.png");
                    break;
                case "Alexander":
                    stream = new FileInputStream("src/practice2/resources/images/Alexander.png");
                    break;
                case "Joane":
                    stream = new FileInputStream("src/practice2/resources/images/Joane.png");
                    break;
                case "Charles":
                    stream = new FileInputStream("src/practice2/resources/images/Charles.png");
                    break;
                case "Eric":
                    stream = new FileInputStream("src/practice2/resources/images/Eric.png");
                    break;
                case "Sebastian":
                    stream = new FileInputStream("src/practice2/resources/images/Sebastian.png");
                    break;
                case "Henry":
                    stream = new FileInputStream("src/practice2/resources/images/Henry.png");
                    break;
                default:
                    stream = new FileInputStream("src/practice2/resources/images/noImage.png");
            }
            Image image = new Image(stream);
            oponentImage.setImage(image);
            if (!fighterName.isEmpty() && !oponentName.isEmpty()) {
                figthButton.setDisable(false);
                oponentImage.setOpacity(1);
                fighterImage.setOpacity(1);
            }
        } catch (NoSelectableCharacterException e) {
            Stage stage = new Stage();
            stage.setTitle("Error Window");
            Label label = new Label("Debe seleccionar otro personaje");
            Scene scene = new Scene(label, 400, 50);
            stage.setScene(scene);
            stage.show();
            figthButton.setDisable(true);
            oponentSelected.valueProperty().set(null);
        }
    }

    public void resetValues(ActionEvent event) throws IOException {
        fighterSelected.valueProperty().set(null);
        oponentSelected.valueProperty().set(null);
        figthButton.setDisable(true);
        oponentImage.setOpacity(1);
        fighterImage.setOpacity(1);
    }

    public void startFight(ActionEvent event) throws IOException {
        Map<String, Character> characters = charactersManager.getCharacters();
        Fighter fighter = (Fighter) characters.get(fighterName);
        Character oponent = characters.get(oponentName);
        if (fighter.fight(oponent)) {
            messageLabel.setText(fighterName + " wins / " + oponentName + " loses");
            oponentImage.setOpacity(0.5);
            message = fighterName + " wins / " + oponentName + " loses";
        } else {
            messageLabel.setText(fighterName + " loses / " + oponentName + " wins");
            fighterImage.setOpacity(0.5);
            message = fighterName + " loses / " + oponentName + " wins";
        }
        resultsWriter.writeInFile(message);
    }

}
