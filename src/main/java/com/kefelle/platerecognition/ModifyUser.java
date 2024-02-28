package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class ModifyUser {
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

        User user = new User(fname,lname,new_username,userpassword,email,1);
        User.updateUser(user);
    }

}
