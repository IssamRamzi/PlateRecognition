package com.kefelle.platerecognition;

import com.kefelle.platerecognition.Database.Connect;
import com.kefelle.platerecognition.Database.Statements;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    static Connect connect = new Connect();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/lists.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Plate Recognition System");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws SQLException {
        Thread thread = new Thread(connect);
        thread.start();
        launch();
    }
}