package com.am.shuffler.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHelper {

    private final String FILENAME = "output.txt";
    public void writeStartToFile(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        writeToFile(dateFormatter.format(now));
        appendToFile("---".repeat(10));
    }

    public void writeToFile(String text){
        try {
            text = text + "\n";
            Files.write(Paths.get(FILENAME), text.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendToFile(String text){
        try {
            text = text + "\n";
            Files.write(Paths.get(FILENAME), text.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void emptyFile(){
        PrintWriter writer;
        try {
            writer = new PrintWriter(FILENAME);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
