package com.qiita.nimzo6689.calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

/**
 *
 * @author nimzo6689
 */
public final class CalcMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private AnchorPane anchorPane;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(true);
        createView();
    }

    @SneakyThrows(IOException.class)
    private void createView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainView.fxml"));
        anchorPane = (AnchorPane) loader.load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
