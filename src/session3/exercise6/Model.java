package session3.exercise6;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Model {
    public void openNewWindow() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Style Selector");
        Parent root= FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void openStyle1(MouseEvent event) throws IOException {
        replaceSceneContent(event);
    }
    private void replaceSceneContent(MouseEvent event) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("Exercise 5.");
        appStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("myScene.css").toExternalForm());
        appStage.show();
    }
}
