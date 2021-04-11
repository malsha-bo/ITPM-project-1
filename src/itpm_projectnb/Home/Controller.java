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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void loadAddStudentGroups(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("addStudentGroups.fxml"));
       Scene scene = new Scene(pane);

       Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.centerOnScreen();
    }
    
    @FXML
    public void loadTags(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("addTags.fxml"));
       Scene scene = new Scene(pane);

       Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.centerOnScreen();
    }   
}

