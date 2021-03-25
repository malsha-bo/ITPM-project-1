/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itpm_projectnb.Home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Adeesha
 */
public class AddStudentGroupsController implements Initializable {

    @FXML
    private ComboBox<?> AcYrComb;
    @FXML
    private ComboBox<?> programComb;
    @FXML
    private ComboBox<?> groupNoComb;
    @FXML
    private ComboBox<?> subgroupNoComb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
