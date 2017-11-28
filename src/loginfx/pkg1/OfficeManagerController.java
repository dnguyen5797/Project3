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

    private ArrayList<BikePart> MainWHArray;

    private void SearchByPartNameAction(ActionEvent SearchByPartName) {
        ExaminePartsTextArea.appendText("\n");
        String name = SearchPartNameText.getText();
                for (int i = 0; i < MainWHArray.size(); i++) {
                    if (MainWHArray.get(i).getPartName().equals(name)) {
                        SearchPartNameText.appendText("Part Information: " + MainWHArray.get(i).getPartName() + "\n" + MainWHArray.get(i).getPartNum() + "\n" + MainWHArray.get(i).getPrice() + "\n" + MainWHArray.get(i).getQuantity() + " \n");
                    }
                }
            
    }

    private void SearchByPartNumberAction(ActionEvent SearchByPartNumber) {

    }

    private void LogoutButtonAction(ActionEvent LogoutButtonAction) {
        try {
            PrintWriter writer = new PrintWriter("MainWH.txt", "UTF-8");
            for (int i = 0; i < MainWHArray.size(); i++) {
                writer.println(MainWHArray.get(i).getPartName() + ", " + MainWHArray.get(i).getPartNum() + ", " + MainWHArray.get(i).getListPrice()
                        + ", " + MainWHArray.get(i).getSalePrice() + ", " + MainWHArray.get(i).isOnSale() + ", " + MainWHArray.get(i).getQuantity());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
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
                System.out.println(Arrays.toString(pv));
                BikePart bp = new BikePart(pv[0], Integer.parseInt(pv[1]), Double.parseDouble(pv[2]), Double.parseDouble(pv[3]), java.lang.Boolean.parseBoolean(pv[4]), Integer.parseInt(pv[5]));
                MainWHArray.add(bp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

}


