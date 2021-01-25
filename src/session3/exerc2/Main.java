package session3.exerc2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WindowwithMessage");
        Label label = new Label("Hi there, this is a window with message!!");
        Scene scene = new Scene(label, 400, 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
