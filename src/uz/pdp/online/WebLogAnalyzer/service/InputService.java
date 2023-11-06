package uz.pdp.online.WebLogAnalyzer.service;

import uz.pdp.online.WebLogAnalyzer.dto.DTO;
import uz.pdp.online.WebLogAnalyzer.logging.ConsoleLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputService {

    private static Map<String,Integer> mapOfIpAdress = new HashMap<>();
    private static List<String> listOfIpAdress = new ArrayList<>();

    private static int numberOfRequests;
    private static int countOf404;

    public static DTO getResult() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("resource/access.txt");
        } catch (FileNotFoundException e) {
            ConsoleLogger.writeLog(InputService.class.getName(), Level.SEVERE, e.getMessage());
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String nextLine;

        try {
            while ((nextLine = bufferedReader.readLine()) != null) {

                numberOfRequests++;
                calculateNumberOf404(nextLine);
                calculateIpAdress(nextLine);

            }
        } catch (IOException e) {
            ConsoleLogger.writeLog(InputService.class.getName(), Level.SEVERE, e.getMessage());
        }

        /*mapOfIpAdress.forEach((k,v) -> {
            System.out.println(k+" - "+v+ " ta");
        });*/

        try {
            bufferedReader.close();
        } catch (IOException e) {
            ConsoleLogger.writeLog(InputService.class.getName(),Level.SEVERE, e.getMessage());
        }



        return new DTO(numberOfRequests,mapOfIpAdress,countOf404);


    }

    private static void calculateNumberOf404(String nextLine) {

        Pattern pattern = Pattern.compile("\\d{3}.$");

        Matcher matcher = pattern.matcher(nextLine);
        String str=null;

        if (matcher.find()) {
            str=matcher.group();
        }
        str = str.substring(0,str.length()-1);

        if (str.equals("404"))
        {
            countOf404++;
        }

    }

    private static void calculateIpAdress(String nextLine) {

        Pattern pattern = Pattern.compile("\\d+[.]\\d+[.]\\d+[.]\\d+");

        Matcher matcher = pattern.matcher(nextLine);
        String str=null;

        if (matcher.find()) {
            str=matcher.group();
        }

        for (String ofIpAdress : listOfIpAdress) {
            if (Objects.equals(str, ofIpAdress)){
//
                mapOfIpAdress.put(ofIpAdress,mapOfIpAdress.get(ofIpAdress)+1);
            }
        }

        listOfIpAdress.add(str);
        mapOfIpAdress.put(str, 1);



    }



    private static Integer addNumber(Object n){

        return (Integer)n+1;
    }
}
