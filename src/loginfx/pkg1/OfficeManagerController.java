/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    @FXML
    private Button OrderQuantityButton;
    
    @FXML
    private TextField EnterOrderQuantity;
    
    @FXML
    private TextArea OrderPartsTextArea;
    
    @FXML
    private TextArea OrderPartsTextArea1;   
    
    private final ArrayList<BikePart> MainWHArray = new ArrayList<>();
//    private ArrayList<BikePart> PartsNeeded;
    @FXML
    private Button LogoutButton;
    @FXML
    private Button LogoutButton1;
    @FXML
    private Button BeginOrderButton;
    @FXML
    private Button LogoutButton2;
    
    @FXML
    private void BeginOrderButtonAction(ActionEvent BeginButtonOrderAction){
        System.out.println("Got here");
        for(int x = 0; x < MainWHArray.size(); x++){
            System.out.println("Got to the first loop");
            if(MainWHArray.get(x).getQuantity() < 5){
                System.out.println("Got to the first if");
                OrderPartsTextArea.appendText("\n"+MainWHArray.get(x).getPartName() + "   --   " + MainWHArray.get(x).getQuantity());
//                PartsNeeded.add(MainWHArray.get(x));
            }
        }
        for(int x = 0; x < MainWHArray.size(); x++){
            if(MainWHArray.get(x).getQuantity() < 5){
                OrderPartsTextArea1.appendText("\n"+MainWHArray.get(x).getPartName() + "   --   " + MainWHArray.get(x).getQuantity());
                OrderPartsTextArea1.appendText("\nHow many parts would you like to order?");
                int whichPart = x;
                OrderQuantityButton.setOnAction((event) -> {
                    if(EnterOrderQuantity.getText().equals(null)){EnterOrderQuantity.setText("0");}
                    int addQuantity = Integer.parseInt(EnterOrderQuantity.getText());
                    EnterOrderQuantity.clear();
                    MainWHArray.get(whichPart).addQuantity(addQuantity);
                    OrderPartsTextArea.appendText("\nOrdered " + addQuantity + "x " + MainWHArray.get(whichPart).getPartName() + ".");
                });
            }
        }
        OrderPartsTextArea.appendText("\nThis order has been completed..");
    }
    
    @FXML
    private void SearchByPartNameAction(ActionEvent SearchByPartNameAction) {
        ExaminePartsTextArea.appendText("\n");
        String name = SearchPartNameText.getText();
                for (int i = 0; i < MainWHArray.size(); i++) {
                    if (MainWHArray.get(i).getPartName().equals(name)) {
                        ExaminePartsTextArea.appendText("Part Information: \n" + 
                                "Part Name: " + MainWHArray.get(i).getPartName() + "\nPart Number: " + MainWHArray.get(i).getPartNum() + "\nPart Price: $" + MainWHArray.get(i).getPrice() + "\nPart Quantity: " + MainWHArray.get(i).getQuantity() + " \n");
                    }
                }
            
    }
    
    @FXML
    private void SearchByPartNumberAction(ActionEvent SearchByPartNumberAction) {
        ExaminePartsTextArea.appendText("\n");
        int name = Integer.parseInt(SearchPartNumberText.getText());
                for (int i = 0; i < MainWHArray.size(); i++) {
                    if (name == MainWHArray.get(i).getPartNum()) {
                        ExaminePartsTextArea.appendText("Part Information: \n" + 
                                "Part Name: " + MainWHArray.get(i).getPartName() + "\nPart Number: " + MainWHArray.get(i).getPartNum() + "\nPart Price: $" + MainWHArray.get(i).getPrice() + "\nPart Quantity: " + MainWHArray.get(i).getQuantity() + " \n");
                    }
                }
    }
    
    @FXML
    private void LogoutButtonAction(ActionEvent LogoutButtonAction) throws IOException {
        try {
            PrintWriter writer = new PrintWriter("MainWH.txt", "UTF-8");
            for (int i = 0; i < MainWHArray.size(); i++) {
                writer.println(MainWHArray.get(i).getPartName() + ", " + MainWHArray.get(i).getPartNum() + ", " + MainWHArray.get(i).getListPrice()
                        + ", " + MainWHArray.get(i).getSalePrice() + ", " + MainWHArray.get(i).isOnSale() + ", " + MainWHArray.get(i).getQuantity());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("file error!");
        }
        Parent youInParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            Scene youInScene = new Scene(youInParent);
            //this line gets the stage information
            Stage window = (Stage)((Node)LogoutButtonAction.getSource()).getScene().getWindow();
            
            window.setScene(youInScene);
            window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("This happens first.");
        File file = new File("MainWH.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] pv = line.split(regExp);
                System.out.println(pv);
                System.out.println(Arrays.toString(pv));
                BikePart bp = new BikePart(pv[0], Integer.parseInt(pv[1]), Double.parseDouble(pv[2]), Double.parseDouble(pv[3]), java.lang.Boolean.parseBoolean(pv[4]), Integer.parseInt(pv[5]));
                System.out.println(bp.getPartName());
                MainWHArray.add(bp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        for(int x = 0; x < MainWHArray.size(); x++){
            if(MainWHArray.get(x).getQuantity() < 5){
                OrderPartsTextArea.appendText("An order needs to be made! \nClick the 'Begin Order' button to start the process.");
                break;
            }
        }
    }

}


