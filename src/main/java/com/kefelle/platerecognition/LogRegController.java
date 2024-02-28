package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class LogRegController {
    @FXML
    private TextField loginEmail;
    @FXML
    private TextField loginPassword;
    @FXML
    private TextField registerEmail;
    @FXML
    private TextField registerPassword;
    @FXML
    private TextField registerConfirmPassword;
    /*
        todo : attributs
    */
    private Stage stage;
    private Scene scene;
    private Parent root;

    /*
        todo : switch views
    */
    @FXML
    public void changeToReg(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login/Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToLogin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login/Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToHome(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
        todo : get textfield infos
    */

    public void getLogin(MouseEvent event) throws IOException, SQLException {
        String login, password;
        login = loginEmail.getText();
        password = loginPassword.getText();
        System.out.println(login + " : " + password);
        Admin admin = new Admin(login, password);
        if (Admin.isAdmin(admin))
            changeToHome(event);
        else System.out.println("Not admin");
    }
    public void getRegister(MouseEvent event) throws IOException {
        String email, password, confirmPassword;
        email = registerEmail.getText();
        password = registerPassword.getText();
        confirmPassword = registerConfirmPassword.getText();
        System.out.println(email + " : " + password + " : " + confirmPassword);
        changeToHome(event);
    }



}
