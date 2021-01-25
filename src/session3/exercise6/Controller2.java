package session3.exercise6;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller2 {
    Model model = new Model();
    public Button style2;
    public Button style1;

    public void openStyle1(MouseEvent mouseEvent) throws IOException {
        model.openStyle1(mouseEvent);
    }


}
