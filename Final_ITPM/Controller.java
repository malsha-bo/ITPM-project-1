/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itpm_projectnb.Home;

import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sudarshana
 */
public class Controller implements Initializable {

    @FXML
    private Button btnLecturer;
    @FXML
    private Button btnSubjects;
    @FXML
    private Button btnDashBoard;
    @FXML
    private Button btnSession;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnLecturer){
            
             loadStage("lecturer.fxml");
        }
        else if(event.getSource() == btnSubjects){
            loadStage("subjects.fxml");
        }else if(event.getSource() == btnDashBoard){
            loadStage("dashboard.fxml");
        }else if(event.getSource() == btnSession){
            loadStage("Location.fxml");
        }
    }
    public void loadStage(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.close();
            stage.setScene(new Scene(root));
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
