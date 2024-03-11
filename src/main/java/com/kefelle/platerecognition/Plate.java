package com.kefelle.platerecognition;

import com.kefelle.platerecognition.Database.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Plate {
    private static Connection connection = Connect.connect();
    private String PlateNumber;
    private int User_ID;

    public static ArrayList<Plate> platesList = new ArrayList<>();
    public Plate(String plateNumber, int user_ID) {
        PlateNumber = plateNumber;
        User_ID = user_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }
    public static ArrayList<Plate> getPlatesList() {
        Plate.getPlates();
        return platesList;
    }
    public static void getPlates() {
        try {
            platesList.clear();
            String sql = "SELECT * FROM plate";
            var statement = connection.createStatement();
            statement.execute("use crs");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                platesList.add(new Plate(resultSet.getString("licence_number"), resultSet.getInt("plate_owner")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
