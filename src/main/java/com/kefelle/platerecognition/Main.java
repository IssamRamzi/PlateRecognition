package com.kefelle.platerecognition;

import com.kefelle.platerecognition.Database.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private static Connect connect = new Connect();
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/connection/signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(new File("src/main/resources/com/kefelle/platerecognition/assets/images/crs.png").toURI().toString());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Plate Recognition System");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        Thread thread = new Thread(connect);
        thread.start();
        launch();
    }
}