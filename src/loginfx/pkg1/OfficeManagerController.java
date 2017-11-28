/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
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

    }

    private void SearchByPartNumberAction(ActionEvent SearchByPartNumber) {

    }

    private void LogoutButtonAction(ActionEvent LogoutButtonAction) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("This happens first.");
        File file = new File("MainWH.txt");
        ArrayList<BikePart> oldList = new ArrayList<BikePart>();
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
            e.printStackTrace();
        }
    }

}


