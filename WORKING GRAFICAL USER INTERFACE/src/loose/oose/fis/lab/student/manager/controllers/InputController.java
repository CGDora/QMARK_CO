//package testbench;
package loose.oose.fis.lab.student.manager.controllers;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.lang.Math;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public void HandleCalculateButtonAction1() {
        int digits = toInt();
        int l=0;
        if (digits <= 0) {
            outputMessage.setText("                       Error");
            outputMessageHistory.setText("");
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
            double calculateTime = Timer.stop()/1000000000.0 ;
            double points = 40 + digits / (200 * log(calculateTime/0.03));

            outputMessage.setText("       " + String.format("%.2f", points) + "");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            //System.out.println(CPUDigitsOfPi.pi);
            FileLogger logger = new FileLogger("history");
            if(points != '0') FileLogger.write((long)points);
            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
            return;
        }
    }

    @FXML
    public void HandleCalculateButtonAction2() {
        int digits = toInt();

        if (digits <= 0) {
            outputMessage.setText("                        Error");
            outputMessageHistory.setText("");
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

            outputMessage.setText("               " + String.format("%.2f", points) + "");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            System.out.println(x);
            FileLogger logger = new FileLogger("history");
            if(points != '0') FileLogger.write((long)points);
            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
            return;
        }
    }
    @FXML
    public void HandleHistoryButtonAction() throws IOException {
        String digits2 = digitsField.getText();

        FileReader fr = new FileReader("history");
        int i;
        outputMessage.setText("");
        String historyResult = "";
        while ((i=fr.read()) != -1) {
            historyResult = historyResult + (char) i;
            //outputMessageHistory.setText(" ");
        }
        fr.close();
        outputMessageHistory.setText("                    "+historyResult);
        //inputMessage.setText("History");

    }

}