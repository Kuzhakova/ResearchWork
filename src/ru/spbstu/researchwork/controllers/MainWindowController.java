package ru.spbstu.researchwork.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.spbstu.researchwork.CSVDataParser;

import java.io.File;

public class MainWindowController {

    @FXML
    private Menu menuSettings;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    private Menu menuScale;

    @FXML
    private MenuItem menuItemOpen;

    @FXML
    private MenuItem menuItemPrint;

    @FXML
    private MenuItem menuItemSaveAs;

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private void initialize() {
        FileChooser fileChooser = new FileChooser();
        CSVDataParser csvtable = new CSVDataParser();

        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                configureFileChooser(fileChooser);
                XYChart.Series<Number, Number> series = null;
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    series = csvtable.chartSeriesFromCsvFile(file);
                }
                lineChart.getData().add(series);

            }

        });
    }

    public void buildChart(XYChart.Series series) {
        series.setName("График");
        lineChart.getData().add(series);
    }

   /* public void buildChart(LinkedList<XYChart.Series> series) {
        for (int i = 0; i < series.size(); i++) {
            series.get(i).setName("График " + (i+1));
            lineChart.getData().add(series.get(i));
        }
    }*/

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View .csv files");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv")
        );
    }
}
