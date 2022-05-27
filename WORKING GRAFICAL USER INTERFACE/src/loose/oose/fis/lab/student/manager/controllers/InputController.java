//package testbench;
package loose.oose.fis.lab.student.manager.controllers;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.Math;
import java.math.BigDecimal;
import java.nio.CharBuffer;

import loose.oose.fis.lab.student.manager.bench.CPUDigitsOfPi;
import loose.oose.fis.lab.student.manager.bench.DigitsOfPi2;
import loose.oose.fis.lab.student.manager.logging.FileLogger;
import loose.oose.fis.lab.student.manager.logging.ConsoleLogger;


import timing.Timer;

import static java.lang.Math.*;


public class InputController {

    @FXML
    public Text inputMessage;
    public Text outputMessageHistory;
    @FXML
    public TextField digitsField;
    @FXML
    public Text outputMessage;
    @FXML
    public Text timeMessage;
    @FXML
    public ListView<String> historyList;

    public void writeLog(String log){
        try{
            FileWriter fileWriter = new FileWriter("history.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println(log);
            bufferedWriter.write(log);
            bufferedWriter.newLine();
            historyList.getItems().add(log);

            bufferedWriter.close();
        }
        catch(Exception ex){
            return;
        }
    }

    public int toInt() {//returns integer version of digitsField
        String toConvert = digitsField.getText();
        int digits = 0;

        try {
            digits = Integer.parseInt(toConvert);
        } catch (NumberFormatException e) {

            // This is thrown when the String
            // contains characters other than digits
            System.out.println("Invalid String");
        }
        return digits;
    }

    @FXML
    public void HandleCalculateButtonAction1(ActionEvent event) {
        int digits = toInt();
        int l=0;
        if (digits <= 0) {
            outputMessage.setText("        Error");
            outputMessageHistory.setText("");
            timeMessage.setText("Time: ");
            l=1;
            return;
        } else {
            outputMessageHistory.setText("");
            //inputMessage.setText("Calculating " + digits + " of Pi");
//CpuBench.java---------------------------------------------------
            Timer.start();
            CPUDigitsOfPi benchmark = new CPUDigitsOfPi();
            benchmark.initialize(9);
            benchmark.warmup();
            benchmark.initialize(9);
            benchmark.run(digits);
            //ConsoleLogger.write(Timer.stop()/1000000);
            double calculatedTime = Timer.stop()/1000000000.0 ;
            double points = 40 + digits / (200 * log(calculatedTime/0.03));

            outputMessage.setText("       " + String.format("%.2f", points));
            timeMessage.setText("Time: " + String.format("%.2f", calculatedTime) + " seconds");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            //System.out.println(CPUDigitsOfPi.pi);
            /**Reading results in the file*/
            String historyLog = LocalDate.now() + ", " + LocalTime.now() + ":  G = "
                    + String.format("%.2f", points) + " (" + digits + " d / " + String.format("%.2f", calculatedTime) + " s)";
            if(points != '0') {
                writeLog(historyLog);
            }

            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
            return;
        }
    }

    @FXML
    public void HandleCalculateButtonAction2(ActionEvent event) {
        int digits = toInt();

        if (digits <= 0) {
            outputMessage.setText("        Error");
            outputMessageHistory.setText("");
            timeMessage.setText("Time: ");
            return;
        } else {
            outputMessageHistory.setText("");
            //inputMessage.setText("Calculating " + digits + " digits of Pi");
//CpuBench.java---------------------------------------------------
            BigDecimal x = new BigDecimal(0);
            Timer.start();
            DigitsOfPi2 benchmark = new DigitsOfPi2();
            benchmark.initialize(100);
            benchmark.warmup();
            benchmark.initialize(digits);

            x=benchmark.run();
            //ConsoleLogger.write(Timer.stop()/1000000);
            double calculatedTime = Timer.stop()/1000000000.0 ;
            double points = digits / ( 1000 * sqrt(calculatedTime));

            outputMessage.setText("       " + String.format("%.2f", points));
            timeMessage.setText("Time: " + String.format("%.2f", calculatedTime) + " seconds");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            System.out.println(x);
            /**Reading results in the file*/
            String historyLog = LocalDate.now() + ", " + LocalTime.now() + ":  H = "
                    + String.format("%.2f", points) + " (" + digits + " d / " + String.format("%.2f", calculatedTime) + " s)";
            if(points != '0') {
                writeLog(historyLog);
            }

            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
            return;
        }
    }
    @FXML
    public void HandleHistoryButtonAction(ActionEvent event) throws IOException {
        String digits2 = digitsField.getText();

        FileReader fileReader = new FileReader("history.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] line = new String[256];
        int i=0;

        historyList.getItems().clear();

        while ((line[i] =bufferedReader.readLine()) != null) {
            //System.out.println(line[i]);
            historyList.getItems().add(line[i]);
            i++;
        }
        bufferedReader.close();

    }

}