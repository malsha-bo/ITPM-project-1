/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itpm_projectnb.Home;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sudarshana
 */
public class LocationController implements Initializable {

    @FXML
    private TextField txtBuildingName;
    @FXML
    private TextField txtRoomName;
    @FXML
    private TextField txtCapacity;
    private RadioButton RLecture;
    private RadioButton RLab1;
    @FXML
    private Button btnsave;
    @FXML
    private ComboBox ddLab;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> hallList = FXCollections.observableArrayList("Lab", "Lecture hall");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ddLab.setItems(hallList);
    } 
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event){
       if(event.getSource() == btnsave){
           insert();
       }
    
    
    }
    public Connection connect() {
        Connection con;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm", "root", "");
            return con;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "can not connect");
            return null;
        }

    }
    public void loadStage(String fxml) {
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
    private void insert(){
        
    
        String query = "INSERT INTO tbllocation(BuildingName,RoomName,RoomType,Capacity) values('"+txtBuildingName.getText()+"','"+txtRoomName.getText()+"','"+ddLab.getValue()+"',"+txtCapacity.getText()+")";
                excecuteQuery(query);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setContentText("Successfully Added");
                alert.showAndWait();
                
                loadStage("ManageLocation.fxml");
    
    }
     private void excecuteQuery(String query) {
        Connection con = connect();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
