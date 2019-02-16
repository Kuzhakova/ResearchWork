package ru.spbstu.researchwork.chartutils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.LinkedList;

public class CharacteristicsСhart {

    Stage primaryStage;

    public CharacteristicsСhart(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void buildChart(LineChart lineChart, LinkedList<XYChart.Series> series) {

        for (int i = 0; i < series.size(); i++) {
            series.get(i).setName("График " + (i+1));
            lineChart.getData().add(series.get(i));
        }
    }
}
