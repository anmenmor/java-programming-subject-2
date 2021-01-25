package session3.exercise5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class RegistrationFormController {
    Model model = new Model();

    public TextField userName;
    public TextField password;

    private void replaceSceneContent(MouseEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("counter.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    public void signIn(MouseEvent mouseEvent) throws IOException {
        if(model.isValidInput(userName.getText(), password.getText())) {
            replaceSceneContent(mouseEvent);
        }

    }
}
