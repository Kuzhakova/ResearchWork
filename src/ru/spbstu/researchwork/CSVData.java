package ru.spbstu.researchwork;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVData {

    public void readCsvFile(File file){
        try {
            Reader fileReader = new FileReader(file);
            CSVReader reader = new CSVReader(fileReader);
            List<String[]> allRows = reader.readAll();
            //Read CSV line by line and use the string array as you want
            for(String[] row : allRows){
                System.out.println(Arrays.toString(row));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(CSVData.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(CSVData.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
