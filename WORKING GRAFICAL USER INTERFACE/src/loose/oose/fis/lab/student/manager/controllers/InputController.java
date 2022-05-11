//package testbench;
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

import bench.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.FileLogger;
import timing.Timer;

public class InputController {

    @FXML
    public Text inputMessage;
    @FXML
    public TextField digitsField;
    @FXML
    public Text outputMessage;

    @FXML
    public void HandleCalculateButtonAction1() {
        String digits = digitsField.getText();

        if (digits == null || digits.isEmpty()) {
            inputMessage.setText("Select number of digits");
            return;
        } else {
            inputMessage.setText("Calculating " + digits + " of Pi");
//CpuBench.java---------------------------------------------------
            Timer.start();
            CPUDigitsOfPi benchmark=new CPUDigitsOfPi();
            benchmark.initialize(9);
            benchmark.warmup();
            benchmark.initialize(9);
            benchmark.run();
            ConsoleLogger.write(Timer.stop()/1000000);
            long score = Timer.stop()/1000000;
            outputMessage.setText("SCORE = " + score);
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            //System.out.println(CPUDigitsOfPi.pi);
            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
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