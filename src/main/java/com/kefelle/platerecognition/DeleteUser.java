package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class DeleteUser {
    @FXML
    private TextField username;

    public void deleteUser(MouseEvent event) throws SQLException {
        String us = username.getText();
        User.deleteUser(us);
    }
}
