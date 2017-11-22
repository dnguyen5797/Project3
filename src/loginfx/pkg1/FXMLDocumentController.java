/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Justin
 */
public class FXMLDocumentController implements Initializable {
    //LOGIN CONTROLLER
    
    @FXML
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
            
    @FXML
    private TextField txtPassword;
    
    
    
            
    public void Login(ActionEvent event) throws IOException{
        if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
            
            //this creates parent and scene for new scene 
            Parent youInParent = FXMLLoader.load(getClass().getResource("youNowInFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
                
        }
        
        else if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("nimda")){
            
            //this creates parent and scene for new scene 
            Parent youInParent = FXMLLoader.load(getClass().getResource("ADMINFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
        }
        
        else if(txtUserName.getText().equals("sales") && txtPassword.getText().equals("sales")){
            
            //this creates parent and scene for new scene 
            Parent youInParent = FXMLLoader.load(getClass().getResource("SALESFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
        }
        
        else{
            lblStatus.setText("Login Failed :( ");
        }
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}
