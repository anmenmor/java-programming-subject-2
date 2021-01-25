package session3.exercise5;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Model {

    public boolean isValidInput(String userName, String password){
        return !userName.isEmpty() && !password.isEmpty();
    }


}
