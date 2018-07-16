package sample.petersonsAlgorithm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Scheduler;

public class ControllerPeterson {

    @FXML
    private Button processOneButton;

    @FXML
    private Button processTwoButton;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize(){
        processOneButton.setOnAction(event -> {
            Scheduler.processOnePeterson = new ProcessOnePeterson(this);
            Scheduler.processOnePeterson.start();
        });

        processTwoButton.setOnAction(event -> {
            Scheduler.processTwoPeterson = new ProcessTwoPeterson(this);
            Scheduler.processTwoPeterson.start();
        });
    }


    public void appendTextArea(String text) {
        this.textArea.appendText(text);
    }

}
