package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFileToList(String inputTextFile) throws Exception {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputTextFile));
            String currentLine = null;
            currentLine = reader.readLine();

        while (currentLine != null){
            lines.add(currentLine);
            currentLine = reader.readLine();
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
        throw new Exception();
    }finally {
            try {
                if (reader != null) {
                        reader.close();
                    }

                } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return lines;
    }

    public static void writeListToFile(String outputTextFile, List<String> lines) throws Exception {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputTextFile));
            BufferedWriter finalWriter = writer;
            lines.stream().forEach(line -> {
                try {
                    finalWriter.write(line);
                    finalWriter.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IOException();
        }
        finally {
            try{
                if(writer != null)    {
                    writer.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
