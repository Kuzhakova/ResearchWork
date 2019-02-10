package ru.spbstu.researchwork;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scenes/mainWindow.fxml"));

        primaryStage.setTitle("Обработка экспериментальных статических характеристик электроприводов");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

        /*final FileChooser fileChooser = new FileChooser();

        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);

        Button button1 = new Button("Select CSV File");
        CSVData csvtable = new CSVData();

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    csvtable.readCsvFile(file);
                }
            }

        });


        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.getChildren().addAll(textArea, button1);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Обработка экспериментальных статических характеристик электроприводов");
        primaryStage.setScene(scene);
        primaryStage.show();*/
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

    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
