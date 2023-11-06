package uz.pdp.online.WebLogAnalyzer.service;

import uz.pdp.online.WebLogAnalyzer.dto.DTO;
import uz.pdp.online.WebLogAnalyzer.logging.ConsoleLogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class OutputService {
    public static void run(DTO dto) {

        FileWriter fileWriter=null;
        try {
             fileWriter = new FileWriter("resource/web_traffic_report.txt");
        } catch (IOException e) {
            ConsoleLogger.writeLog(OutputService.class.getName(), Level.SEVERE, e.getMessage());
        }

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            bufferedWriter.write("Jami so'rovlar soni - "+dto.getNumberOfRequests()+" ta\n");
            bufferedWriter.write("Jami 404 statusi bo'yicha so'rovlar soni - "+dto.getNumberOf404Requests()+" ta\n\n");

            dto.getNumberOfIpAdress().forEach((k,v) -> {
                try {
                    bufferedWriter.write(k+" - "+v+ " marta qatnashgan\n");
                } catch (IOException e) {
                    ConsoleLogger.writeLog(OutputService.class.getName(), Level.SEVERE, e.getMessage());
                }
            });

        } catch (IOException e) {
            ConsoleLogger.writeLog(OutputService.class.getName(), Level.SEVERE, e.getMessage());
        }

        try {
            bufferedWriter.close();
        } catch (IOException e) {
            ConsoleLogger.writeLog(OutputService.class.getName(), Level.SEVERE, e.getMessage());
        }


    }
}
