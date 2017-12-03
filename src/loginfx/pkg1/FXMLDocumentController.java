
 package loginfx.pkg1;
 
import java.io.File;
 import java.io.IOException;
 import java.net.URL;
import java.util.ArrayList;
 import java.util.ResourceBundle;
import java.util.Scanner;
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
     //LOGIN CONTROLLER // Testing changes
     
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
         
         else if(txtUserName.getText().equals("office") && txtPassword.getText().equals("manager")){
             Parent youInParent = FXMLLoader.load(getClass().getResource("OfficeManager.fxml"));
             Scene youInScene = new Scene (youInParent);
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
     
     
     public static void LoginProto(String[] args) throws Exception {
     File file = new File("members.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            
            String line = sc.nextLine();
            String[] members = line.split(":");
            Users u = new Users(members[0],members[1],members[2]);
            Users found = findByUserName(members[0]);
            if(found==null){
                UsersArray.add(u);
            }
            else{
                found.setPassword(u.getPassword());
                found.setFXMLfile(u.getFXMLfile());
        }
    }
        System.out.println("Users" + UsersArray.toString());
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username: ");
            String userName = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            
            for (int i = 0; i < UsersArray.size(); i++) {
                if (UsersArray.get(i).userCheck(userName) == true && UsersArray.get(i).passCheck(password) == true) {
                    System.out.println("Login SUCCCsefull");
                    String FXML = UsersArray.get(i).getFXMLfile();
                    
                    System.out.println("FXMl is " + FXML);
                    break;
                }
                else{
                    System.out.println("not logged in");
                    break;
            }
            }
    }
    
    private static Users findByUserName(String name){
        for (Users u : UsersArray)
            if (u.getUserName().equals(name)){
                return u;
            }
               return null; 
    }
    
        private static final ArrayList<Users> UsersArray = new ArrayList<>();
        
}


     
 