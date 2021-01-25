package session3.exercise4;



import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    ArrayList<User> users = new ArrayList<>();

    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void submit(String fullname, String email, String password) {
        Stage stage = new Stage();
        stage.setTitle("New Window");
        Label label = new Label("");
        Scene scene = new Scene(label, 400, 50);
        stage.setScene(scene);
        if(fullname.isEmpty()) {
            label.setText("Fullname is empty");
            stage.show();
        } else if (email.isEmpty()) {
            label.setText("Email is empty");
            stage.show();
        } else if (!isValidEmailAddress(email)) {
            label.setText("Email is invalid");
            stage.show();
        } else if (password.isEmpty()) {
            label.setText("Password is empty");
            stage.show();
        } else {
            User user = new User(fullname, email, password);
            users.add(user);
            label.setText("Users list: \n" + users.toString());
            stage.show();
        }
    }
}
