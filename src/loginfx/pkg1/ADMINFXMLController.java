/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * 
 * @author Justin
 */
public class ADMINFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField saleAccField;
    @FXML private TextField saleUserAdd;
    @FXML private TextField salePassAdd;
    @FXML private TextField saleAccDel;
    @FXML private TextField saleEditField;
    
    @FXML private TextField officeAccField;
    @FXML private TextField officeUserAdd;
    @FXML private TextField officePassAdd;
    @FXML private TextField officeAccDel;
    @FXML private TextField officeEditField;
    
    @FXML private TextField warehouseAccField;
    @FXML private TextField warehouseUserAdd;
    @FXML private TextField warehousePassAdd;
    @FXML private TextField warehouseAccDel;
    @FXML private TextField warehouseEditField;
    
    @FXML
    public void saleAccAdd(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void saleAccDel(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void officeAccAdd(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void officeAccDel(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void wareAccAdd(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void wareAccDel(ActionEvent event) throws IOException{
        
    }
    @FXML
    public void Logout(ActionEvent event) throws IOException{
        Parent youInParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
