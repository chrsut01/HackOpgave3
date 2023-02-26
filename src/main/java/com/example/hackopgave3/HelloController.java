package com.example.hackopgave3;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController {

        @FXML
        private TextField passwordTF;

        @FXML
        private Label readOutLabel;

        @FXML
        private TextField userTF;


    @FXML
    void submit(ActionEvent event) {

        int numberRows = 0;
            String insertUser = userTF.getText();
            String insertPassword = passwordTF.getText();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE userName="+ insertUser+ "AND passWord="+ insertPassword;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");


                System.out.println(userName + ", " + passWord + ", ");
                ++numberRows;
                //readOutLabel.setText("Welcome" + userName);
            }
        }
        // Exception handling: skriv fejlen ud og log den
        catch (SQLServerException sqlse) {
            System.out.println(sqlse);
        } catch (SQLException ex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

        readOutLabel.setText(numberRows + " were accessed");
        userTF.clear();
        passwordTF.clear();
        //readOutLabel.setText("Welcome" + userName);
    }

}