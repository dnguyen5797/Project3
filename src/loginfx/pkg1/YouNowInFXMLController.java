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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Justin
 */
public class YouNowInFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Button btnLogout;
    
    @FXML
    private Button btnShow;
    
    @FXML
    private TextArea txtShow;
    
    public void Logout(ActionEvent event) throws IOException{
        Parent youInParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
    }
    
    public void Show(ActionEvent event){
        txtShow.setText("(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻\n(╯°□°）╯︵ ┻━┻");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
