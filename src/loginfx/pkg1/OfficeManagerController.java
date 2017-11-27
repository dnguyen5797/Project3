/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jarre
 */
public class OfficeManagerController implements Initializable {

    @FXML
    private TextArea ExaminePartsTextArea;
    
    @FXML
    private Button SearchPartNameButton;
    
    @FXML
    private Button SearchPartNumberButton;
    
    @FXML
    private TextField SearchPartNameText;
    
    @FXML
    private TextField SearchPartNumberText;
    
    private void SearchByPartNameAction(ActionEvent SearchByPartName){
        
    }
    private void SearchByPartNumberAction(ActionEvent SearchByPartNumber){
        
    }
    private void LogoutButtonAction(ActionEvent LogoutButtonAction){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("This happens first.");
    }    
    
}
