/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itpm_projectnb.Home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{
 
    @FXML
    private AnchorPane rootPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void loadAddStudentGroups(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("addStudentGroups.fxml"));
       rootPane.getChildren().setAll(pane);
    }
    



   
}

