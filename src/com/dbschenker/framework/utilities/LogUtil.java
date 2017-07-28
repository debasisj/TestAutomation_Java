package com.dbschenker.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Log utility class
 */
public class LogUtil {
    static BufferedWriter bufferedWriter = null;

    //file format
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);

    public void createlogFile(){
        try {

            File dir = new File("C:\\Users\\djagadeb\\Source\\Repos\\TestAutomation_Java\\src\\Logs");
            if(!dir.exists()) dir.mkdir();
            //create a log file
            File logFile = new File(dir+"\\"+fileNameFormat+".log");

            //create file writer
            FileWriter fileWriter = new FileWriter(logFile.getAbsolutePath());
            bufferedWriter = new BufferedWriter(fileWriter);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeLog(String message){
        try {
            bufferedWriter.write(message);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
