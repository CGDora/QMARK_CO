package loose.oose.fis.lab.student.manager.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class InputController {

    @FXML
    public Text inputMessage;
    @FXML
    public TextField digitsField;

    @FXML
    public void HandleCalculateButtonAction1() {
        String digits = digitsField.getText();

        if (digits == null || digits.isEmpty()) {
            inputMessage.setText("Select number of digits");
            return;
        } else {
            inputMessage.setText("Calculating " + digits + " of Pi");
            return;
        }
/*
        if (digits.equals("teacher")) {
            try {
                Stage stage = (Stage) inputMessage.getScene().getWindow();
                Parent viewStudentsRoot = FXMLLoader.load(getClass().getResource("../fxml/view-students.fxml"));
                Scene scene = new Scene(viewStudentsRoot, 600, 400);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return;
        }*/


        //inputMessage.setText("Incorrect input!");
    }

    @FXML
    public void HandleCalculateButtonAction2() {
        String digits = digitsField.getText();


        inputMessage.setText("Method 2!");


    }

    @FXML
    public void HandleHistoryButtonAction() {
        String digits = digitsField.getText();


        inputMessage.setText("History or database");


    }

}