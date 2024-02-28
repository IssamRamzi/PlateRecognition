package com.kefelle.platerecognition;

import com.kefelle.platerecognition.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class AddUser {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private TextField Fname;
    @FXML private TextField Lname;

    public void addUser(MouseEvent event) throws SQLException {
        String username = this.username.getText();
        String password = this.password.getText();
        String email = this.email.getText();
        String Fname = this.Fname.getText();
        String Lname = this.Lname.getText();
        User user = new User(Fname,Lname,username,password,email,76);
        User.addUser(user);
    }
}
