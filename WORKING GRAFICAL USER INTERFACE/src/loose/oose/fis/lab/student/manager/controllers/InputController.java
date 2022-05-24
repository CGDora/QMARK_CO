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

import static java.lang.Math.pow;


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

        if (digits <= 0) {
            inputMessage.setText("Select number of digits");
            return;
        } else {
            inputMessage.setText("Calculating " + digits + " of Pi");
//CpuBench.java---------------------------------------------------
            Timer.start();
            CPUDigitsOfPi benchmark = new CPUDigitsOfPi();
            benchmark.initialize(9);
            benchmark.warmup();
            benchmark.initialize(9);
            benchmark.run(digits);
            //ConsoleLogger.write(Timer.stop()/1000000);
            long score = Timer.stop()/1000000 ;
            double points;
            points=pow(score,-1);
            points=points*100;
            outputMessage.setText("TEMP SCORE = " + (long)points + "");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            //System.out.println(CPUDigitsOfPi.pi);
            FileLogger logger = new FileLogger("history");
            FileLogger.write((long)points);
            ConsoleLogger.close();
//---------------------------------------------------CpuBench.java
            return;
        }
    }

    @FXML
    public void HandleCalculateButtonAction2() {
        int digits = toInt();

        if (digits <= 0) {
            inputMessage.setText("Select number of digits");
            return;
        } else {
            inputMessage.setText("Calculating " + digits + " of Pi");
//CpuBench.java---------------------------------------------------
            BigDecimal x = new BigDecimal(0);
            Timer.start();
            DigitsOfPi2 benchmark = new DigitsOfPi2();
            benchmark.initialize(100);
            benchmark.warmup();
            benchmark.initialize(digits);

            x=benchmark.run();
            //ConsoleLogger.write(Timer.stop()/1000000);
            long score = Timer.stop();
            double points;
            points=pow(score,-1)/1000000 ;
            points = points *100;
            outputMessage.setText("TEMP SCORE = " + points + "");
            //Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
            //ConsoleLogger.write(Offset);
            System.out.println(x);
            FileLogger logger = new FileLogger("history");
            FileLogger.write((long)points);
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
            String historyResult = "";
            while ((i = fr.read()) != -1)
                historyResult = historyResult + (char) i;
            fr.close();
            inputMessage.setText("History");
            outputMessageHistory.setText(historyResult);


        }

    }