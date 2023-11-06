package uz.pdp.online.WebLogAnalyzer.service;

import uz.pdp.online.WebLogAnalyzer.logging.ConsoleLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

public class InputService {

    public static void getResult(){

        FileReader fileReader=null;
        try {
             fileReader = new FileReader("resource/acces.txt");
        } catch (FileNotFoundException e) {
            ConsoleLogger.writeLog(InputService.class.getName(), Level.SEVERE, e.getMessage());
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String nextLine;

            try {
                while ((nextLine=bufferedReader.readLine())!=null) {




                }
            } catch (IOException e) {
                ConsoleLogger.writeLog(InputService.class.getName(), Level.SEVERE,e.getMessage());
            }
    }
}
