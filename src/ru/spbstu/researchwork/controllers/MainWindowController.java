package ru.spbstu.researchwork.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.spbstu.researchwork.CSVData;

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
    private void initialize() {
        FileChooser fileChooser = new FileChooser();
        CSVData csvtable = new CSVData();

        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    csvtable.readCsvFile(file);
                }
            }

        });
    }

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
