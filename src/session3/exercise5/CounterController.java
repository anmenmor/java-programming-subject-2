package session3.exercise5;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class CounterController {

    public Label labelCounter;
    public Button subButton;
    public Button addButton;
    public Button resetButton;
    public RadioButton radioStroke1;
    public ToggleGroup strokeGroup;
    public RadioButton radioStroke2;
    public RadioButton radioStroke3;
    public RadioButton radioStroke4;

    public void increment(MouseEvent mouseEvent) {
       int currentValue = Integer.parseInt(labelCounter.getText());
       int selectedValue = Integer.parseInt(strokeGroup.getSelectedToggle().getUserData().toString());
       int newValue = currentValue + selectedValue;
       labelCounter.setText(String.valueOf(newValue));
    }
    public void decrement(MouseEvent mouseEvent) {
        int currentValue = Integer.parseInt(labelCounter.getText());
        int selectedValue = Integer.parseInt(strokeGroup.getSelectedToggle().getUserData().toString());
        int newValue = currentValue - selectedValue;
        labelCounter.setText(String.valueOf(newValue));
    }
    public void reset(MouseEvent mouseEvent) {
        labelCounter.setText(String.valueOf(0));
    }
}
