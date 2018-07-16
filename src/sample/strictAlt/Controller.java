package sample.strictAlt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Scheduler;

public class Controller {

    @FXML
    private Button processOneButton;

    @FXML
    private Button processTwoButton;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        processOneButton.setOnAction(event -> {

            if (Scheduler.processOne == null) {
                Scheduler.processOne = new ProcessOne(this);
                Scheduler.processOne.start();
            } else {
                appendTextArea("Process " + Scheduler.processOne.processId + " is running.\n");
            }
        });

        processTwoButton.setOnAction(event -> {
            if (Scheduler.processTwo == null) {
                Scheduler.processTwo = new ProcessTwo(this);
                Scheduler.processTwo.start();
            } else {
                appendTextArea("Process " + Scheduler.processTwo.processId + " is running.\n");
            }
        });
    }

    void appendTextArea(String text) {
        textArea.appendText(text);
    }
}
