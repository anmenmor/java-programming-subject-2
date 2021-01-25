package session3.exerc3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private Label myMEssage;
    public void printSomething(MouseEvent event){
        myMEssage.setText("Great!! It works.");
    }
}
