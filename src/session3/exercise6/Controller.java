package session3.exercise6;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller {
    Model model = new Model();
    public Button button;

    public void openNewWindow(MouseEvent mouseEvent) throws IOException {
        model.openNewWindow();
    }
}
