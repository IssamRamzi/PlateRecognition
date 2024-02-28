package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class MenuController {
    /*
        todo : attributs
    */
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField searchField = new TextField();
    @FXML
    public ScrollPane scrollPane;
    @FXML
    VBox vBox = new VBox();

    /*
        todo : switch scenes
    */
    @FXML
    public void changeToHome(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToProfile(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/AdminProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToLists(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Lists.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToStatistics(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Statistics.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToManual(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Manual.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToContact(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Contact.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
        todo : Lists

        * : fix displayUsers method to display the users that are new in the VBox and also clear the VBox before when redisplaying the users
    */

    public void displayUsers(MouseEvent event) throws SQLException {
        // ! not working
        clearVBox();
        scrollPane.setContent(null);
        var list = User.getUsersList();
        for (User user : list) {
            Text userText = new Text(user.toString());
            vBox.getChildren().add(userText);
        }
        scrollPane.setContent(vBox);
        scrollPane.setPannable(true);
    }
    public void searchUserKeyBoard(KeyEvent event) throws SQLException {
        // ! not working (When pressing enter)

        if (event.getCode() == KeyCode.ENTER) {
            String search = searchField.getText();
            try {
                if (User.isUser(search)) {
                    clearVBox();
                    Text userText = new Text(User.getUser(search).toString());
                    System.out.println(User.getUser(search));
                    vBox.getChildren().add(userText);
                    scrollPane.setContent(vBox);
                    scrollPane.setPannable(true);
                } else {
                    Text text = new Text("User not found");
                    text.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: red;");
                    clearVBox();
                    vBox.getChildren().add(text);
                    scrollPane.setContent(vBox);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void searchUser(MouseEvent event) {
        String search = searchField.getText();
        try {
            if (User.isUser(search)) {
                clearVBox();
                Text userText = new Text(User.getUser(search).toString());
                System.out.println(User.getUser(search));
                vBox.getChildren().add(userText);
                scrollPane.setContent(vBox);
                scrollPane.setPannable(true);
            } else {
                Text text = new Text("User not found");
                text.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: red;");
                clearVBox();
                vBox.getChildren().add(text);
                scrollPane.setContent(vBox);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void clearVBox(){
        vBox.getChildren().clear();
    }
    public void addNewUser(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/AddUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("AddUser");
        s.setScene(scene);
        s.show();
//        User.addUser();
    }
    public void deleteUser(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/DeleteUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Delete User");
        s.setScene(scene);
        s.show();
    }
    public void modifyUser(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/ModifyUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Modify User");
        s.setScene(scene);
        s.show();
    }
    
}
