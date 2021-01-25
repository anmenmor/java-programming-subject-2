package session3.exercise4;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    Model model = new Model();
    @FXML
    TextField fullname = new TextField();
    public TextField email;
    public PasswordField password;


    public void submit(MouseEvent mouseEvent) {
        model.submit(fullname.getText(), email.getText(), password.getText());
    }
}
