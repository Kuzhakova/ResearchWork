package ru.spbstu.researchwork;

import com.opencsv.CSVReader;
import javafx.scene.chart.XYChart;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVDataParser {

    public XYChart.Series chartSeriesFromCsvFile(File file) {
        try {
            Reader fileReader = new FileReader(file);
            CSVReader reader = new CSVReader(fileReader);
            List<String[]> allRows = reader.readAll();

            for (String[] row : allRows) {
                System.out.println(Arrays.toString(row));
            }
            fileReader.close();

            XYChart.Series<Number, Number> series = new XYChart.Series();
            series.getData().add(new XYChart.Data(1, 23));
            series.getData().add(new XYChart.Data(2, 14));
            series.getData().add(new XYChart.Data(3, 15));
            series.getData().add(new XYChart.Data(4, 24));
            series.getData().add(new XYChart.Data(5, 34));
            series.getData().add(new XYChart.Data(6, 36));
            series.getData().add(new XYChart.Data(7, 22));
            series.getData().add(new XYChart.Data(8, 45));
            series.getData().add(new XYChart.Data(9, 43));
            series.getData().add(new XYChart.Data(10, 17));
            series.getData().add(new XYChart.Data(11, 29));
            series.getData().add(new XYChart.Data(12, 25));
            return series;

        } catch (FileNotFoundException e) {
            Logger.getLogger(CSVDataParser.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(CSVDataParser.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
