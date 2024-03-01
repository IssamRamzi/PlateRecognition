package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ModifyUser {
    @FXML private AnchorPane anchorPane;
    private @FXML TextField username;
    @FXML
    private TextField new_fname;
    @FXML
    private TextField new_lname;
    @FXML
    private TextField new_userpassword;
    @FXML
    private TextField new_email;

    public void modifyUser(MouseEvent event) throws SQLException {

        String new_username = username.getText();
        String fname = new_fname.getText();
        String lname = new_lname.getText();
        String userpassword = new_userpassword.getText();
        String email = new_email.getText();
        if(fname.isEmpty()) {
            fname = User.getUser(new_username).getFname();
        }
        if(lname.isEmpty()) {
            lname = User.getUser(new_username).getLname();
        }
        if(userpassword.isEmpty()) {
            userpassword = User.getUser(new_username).getUserPassword();
        }
        if(email.isEmpty()) {
            email = User.getUser(new_username).getEmail();
        }

        User user = new User(fname,lname,new_username,userpassword,email,1);
        User.updateUser(user);
    }
    public void displayUser(MouseEvent event) throws SQLException {

        String new_username = username.getText();
        User user = User.getUser(new_username);
        new_fname.setText(user.getFname());
        new_lname.setText(user.getLname());
        new_userpassword.setText(user.getUserPassword());
        new_email.setText(user.getEmail());
        Text text = new Text(user.getFname() + " " + user.getLname() + " " + user.getUsername() + " " + user.getUserPassword() + " " + user.getEmail());
        text.setX(50);
        text.setY(50);
        anchorPane.getChildren().add(text);
    }

}
