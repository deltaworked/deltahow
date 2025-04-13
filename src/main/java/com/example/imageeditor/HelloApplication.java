package com.example.imageeditor;

import controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button openButton = new Button("Открыть");
        Button applyButton = new Button("Применить");
        Button saveButton = new Button("Сохранить");

        ComboBox<String> filterBox = new ComboBox<>();
        filterBox.getItems().addAll("Grayscale", "Invert", "Blur");
        filterBox.setValue("Grayscale");

        ImageView originalView = new ImageView();
        ImageView resultView = new ImageView();

        originalView.setFitWidth(300);
        originalView.setPreserveRatio(true);
        resultView.setFitWidth(300);
        resultView.setPreserveRatio(true);

        HBox imageBox = new HBox(10, originalView, resultView);
        HBox controls = new HBox(10, openButton, filterBox, applyButton, saveButton);
        VBox root = new VBox(10, imageBox, controls);

        MainController controller = new MainController(originalView, resultView, filterBox);

        openButton.setOnAction(e -> controller.loadImage());
        applyButton.setOnAction(e -> controller.applyFilter());
        saveButton.setOnAction(e -> controller.saveImage());

        stage.setTitle("Image Editor");
        stage.setScene(new Scene(root, 640, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}