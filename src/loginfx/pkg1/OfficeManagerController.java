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
    
    @FXML
    private Button LogoutButton;
    @FXML
    private Button LogoutButton1;
    @FXML
    private Button BeginOrderButton;
    @FXML
    private Button LogoutButton2;
    
    private ArrayList<OrderPart> partsNeeded = new ArrayList<>();

    @FXML
    private void BeginOrderButtonAction(ActionEvent BeginButtonOrderAction) {
        for (int x = 0; x < MainWHArray.size(); x++) {
            if (MainWHArray.get(x).getQuantity() < 5) {
                OrderPartsTextArea.appendText("\n" + MainWHArray.get(x).getPartName() + "   --   " + MainWHArray.get(x).getQuantity());
                OrderPart temp = new OrderPart(MainWHArray.get(x), 0);
                partsNeeded.add(temp);
            }
        }
        OrderPartsTextArea1.appendText("\nEnter the number of parts you want to order, \nin order, separated by commas.");
    }
    
    @FXML
    private void OrderQuantityButton(ActionEvent OrderQuantityAction){
        System.out.println("Got here");
        String numbers = EnterOrderQuantity.getText();
        String regExp = "\\s*(\\s|,)\\s*";
        String[] splitNumbers = numbers.split(regExp);
        System.out.println(Arrays.toString(splitNumbers));
        ArrayList<Integer> ints = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            ints.add(Integer.parseInt(splitNumber));
        }
        System.out.println("Loop 1");
        for(int i = 0; i < partsNeeded.size();i++){
            partsNeeded.get(i).setNewQuantity(ints.get(i));
        }
        System.out.println("Loop 2");
        int z = 0;
        for (int y = 0; y < MainWHArray.size(); y++) {
            if(partsNeeded.get(z).getOPBP() == MainWHArray.get(y)){
                MainWHArray.get(y).addQuantity(partsNeeded.get(z).getNewQuantity());
                OrderPartsTextArea1.appendText("\nOrder made for "+MainWHArray.get(y).getPartName()+". New quantity: "+MainWHArray.get(y).getQuantity());
                z++;
            }
        }
        System.out.println("Loop 3");
    }

    @FXML
    private void SearchByPartNameAction(ActionEvent SearchByPartNameAction) {
        ExaminePartsTextArea.appendText("\n");
        String name = SearchPartNameText.getText();
        for (int i = 0; i < MainWHArray.size(); i++) {
            if (MainWHArray.get(i).getPartName().equals(name)) {
                ExaminePartsTextArea.appendText("Part Information: \n"
                        + "Part Name: " + MainWHArray.get(i).getPartName() + "\nPart Number: " + MainWHArray.get(i).getPartNum() + "\nPart Price: $" + MainWHArray.get(i).getPrice() + "\nPart Quantity: " + MainWHArray.get(i).getQuantity() + " \n");
            }
        }

    }

    @FXML
    private void SearchByPartNumberAction(ActionEvent SearchByPartNumberAction) {
        ExaminePartsTextArea.appendText("\n");
        int name = Integer.parseInt(SearchPartNumberText.getText());
        for (int i = 0; i < MainWHArray.size(); i++) {
            if (name == MainWHArray.get(i).getPartNum()) {
                ExaminePartsTextArea.appendText("Part Information: \n"
                        + "Part Name: " + MainWHArray.get(i).getPartName() + "\nPart Number: " + MainWHArray.get(i).getPartNum() + "\nPart Price: $" + MainWHArray.get(i).getPrice() + "\nPart Quantity: " + MainWHArray.get(i).getQuantity() + " \n");
            }
        }
    }

    @FXML
    private void LogoutButtonAction(ActionEvent LogoutButtonAction) throws IOException {
        try {
            try (PrintWriter writer = new PrintWriter("MainWH.txt", "UTF-8")) {
                for (int i = 0; i < MainWHArray.size(); i++) {
                    writer.println(MainWHArray.get(i).getPartName() + ", " + MainWHArray.get(i).getPartNum() + ", " + MainWHArray.get(i).getListPrice()
                            + ", " + MainWHArray.get(i).getSalePrice() + ", " + MainWHArray.get(i).isOnSale() + ", " + MainWHArray.get(i).getQuantity());
                }
            }

        } catch (IOException e) {
            System.out.println("file error!");
        }
        Parent youInParent = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene youInScene = new Scene(youInParent);
        Stage window = (Stage) ((Node) LogoutButtonAction.getSource()).getScene().getWindow();

        window.setScene(youInScene);
        window.show();
    }
    
    @FXML
    private void FindPayAction(ActionEvent FindPayAction){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderPartsTextArea1.appendText("-----");
        System.out.println("This happens first.");
        File file = new File("MainWH.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] pv = line.split(regExp);
                System.out.println(Arrays.toString(pv));
                BikePart bp = new BikePart(pv[0], Integer.parseInt(pv[1]), Double.parseDouble(pv[2]), Double.parseDouble(pv[3]), java.lang.Boolean.parseBoolean(pv[4]), Integer.parseInt(pv[5]));
                System.out.println(bp.getPartName());
                MainWHArray.add(bp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        for (int x = 0; x < MainWHArray.size(); x++) {
            if (MainWHArray.get(x).getQuantity() < 5) {
                OrderPartsTextArea.appendText("An order needs to be made! \nClick the 'Begin Order' button to start the process.");
                break;
            }
        }
    }

}
