/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itpm_projectnb.Home;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sudarshana
 */
public class ManageLocationController implements Initializable {

    @FXML
    private TextField txtBuildingName;
    @FXML
    private TextField txtRoomName;
    @FXML
    private TextField txtCapacity;
    @FXML
    private ComboBox ddLab;
    @FXML
    private TableView<tbllocation> tv;
    @FXML
    private TableColumn<tbllocation, String> colBuildingName;
    @FXML
    private TableColumn<tbllocation, String> colRoomName;
    @FXML
    private TableColumn<tbllocation, String> colRoomType;
    @FXML
    private TableColumn<tbllocation, Integer> colCapacity;
    @FXML
    private TableColumn<tbllocation, Integer> colLocationID;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> hallList = FXCollections.observableArrayList("Lab", "Lecture hall");
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ddLab.setItems(hallList);
        
        showLocations();
        retrieve();
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
    @FXML
    public void handleButtonAction(ActionEvent event) {
     if(event.getSource() == btnUpdate){
         update();
     
     }else if(event.getSource() == btnDelete){
         delete();
     
     }
    
    
    }
    public ObservableList<tbllocation> getLocationList() {
        ObservableList<tbllocation> locationList = FXCollections.observableArrayList();
        Connection con = connect();

        String query = "select * from tbllocation";
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            tbllocation location;

            while (rs.next()) {
                location = new tbllocation(rs.getInt("LocationID"), rs.getString("BuildingName"), rs.getString("RoomName"), rs.getString("RoomType"), rs.getInt("Capacity"));
                locationList.add(location);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return locationList;

    }
    public void showLocations() {
       
        ObservableList<tbllocation> list = getLocationList();

        colLocationID.setCellValueFactory(new PropertyValueFactory<tbllocation, Integer>("LocationID"));
        colBuildingName.setCellValueFactory(new PropertyValueFactory<tbllocation, String>("BuildingName"));
        colRoomName.setCellValueFactory(new PropertyValueFactory<tbllocation, String>("RoomName"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<tbllocation, String>("RoomType"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<tbllocation, Integer>("Capacity"));
        

        

        tv.setItems(list);
    }

     @FXML
    public void retrieve() {
        /* cMonday = new CheckBox("Monday");
                        cMonday.setOnAction(e ->{
                            checkBoxList.add(cMonday.getText());
                         });
                        cTuesday = new CheckBox("Tueday");
                        cTuesday.setOnAction(e ->{
                            checkBoxList.add(cTuesday.getText());
                         });
                        cWednesday = new CheckBox("Wednesday");
                        cWednesday.setOnAction(e ->{
                            checkBoxList.add(cWednesday.getText());
                         });
                        cThursday = new CheckBox("Thursday");
                        cThursday.setOnAction(e ->{
                            checkBoxList.add(cThursday.getText());
                         });
                        cFriday = new CheckBox("Friday");
                        cFriday.setOnAction(e ->{
                            checkBoxList.add(cFriday.getText());
                         });
                        cSaturday = new CheckBox("Saturday");
                        cSaturday.setOnAction(e ->{
                            checkBoxList.add(cSaturday.getText());
                         });
                        cSunday = new CheckBox("Sunday");
                        cSunday.setOnAction(e ->{
                            checkBoxList.add(cSunday.getText());
                         });*/
        tv.setOnMouseClicked(e -> {
            Connection con = connect();
            try {
                tbllocation location = (tbllocation) tv.getSelectionModel().getSelectedItem();

                String query = "SELECT * FROM tbllocation WHERE LocationID=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, location.getLocationID());
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    txtBuildingName.setText(rs.getString("BuildingName"));
                    txtRoomName.setText(rs.getString("RoomName"));
                    ddLab.setValue(rs.getString("RoomType"));
                    txtCapacity.setText(rs.getString("Capacity"));
                    
                }
            }catch(Exception ex){
            
            }

                });
    }   
    public void update() {
        btnUpdate.setOnAction(e -> {
            

                    String query = "UPDATE tbllocation SET BuildingName='" + txtBuildingName.getText() + "',RoomName='" + txtRoomName.getText() + "',RoomType='" + ddLab.getValue() + "',Capacity=" + txtCapacity.getText() + " where BuildingName= '"+txtBuildingName.getText()+"'";
                    excecuteQuery(query);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Information Dialog");
                    alert.setContentText("Updated successfully");
                    alert.showAndWait();
                    showLocations();
                    
                


        });

    }

    public void delete() {

        String query = "delete from tbllocation where BuildingName = '" + txtBuildingName.getText() + "'";
        excecuteQuery(query);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("Deleted successfully");
        alert.showAndWait();
        showLocations();
        

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
