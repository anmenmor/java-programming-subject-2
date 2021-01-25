package practice2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import practice2.model.Users;

import java.io.IOException;

public class LoginController {

    @FXML
    public TextField usernameInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Button signInButton;
    Users users = new Users();

    public LoginController() throws IOException {
    }

    public void login(MouseEvent event) throws IOException {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        if(users.userExist(username, password)) {
            replaceSceneContent(event);
        } else {
            Stage stage = new Stage();
            stage.setTitle("Error Window");
            Label label = new Label("Usuario o contraseña incorrectos");
            Scene scene = new Scene(label, 400, 50);
            stage.setScene(scene);
            stage.show();
        }

    }
    private void replaceSceneContent(MouseEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("../view/gameView.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("Aplicacion lucha");
        appStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("../resources/styles/gameView.css").toExternalForm());
        appStage.show();
    }
}
