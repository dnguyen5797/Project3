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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Duy
 */
public class AccountFileReader {
    
    String fileName;
    ArrayList<Accounts> retList;

    /**
     * Takes file name
     * @param fileName
     */
    public AccountFileReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Places the objects collected into an array
     *
     * @return
     */
    public ArrayList<Accounts> getInfo() {
        File file = new File(fileName);
        try {
            retList = new ArrayList<>();
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s";
                String[] pv = line.split(",");
                Accounts accArray = new Accounts(pv[0], pv[1], pv[2]);
                retList.add(accArray);
            }
            return retList;
        } catch (FileNotFoundException e) {
            System.out.println("File was not Found");
            e.printStackTrace();
            return retList;
        }
    }

    /**
     * Returns the Accounts array
     *
     * @return
     */
    public ArrayList<Accounts> getAcc() {
        return retList;
    }

    /**
     * Writes the file out
     *
     * @param fileName
     * @param accArray
     */
    public static void writeFile(String fileName, ArrayList<Accounts> accArray) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (Accounts acc : accArray) {
                writer.println(acc); // uses Accounts toString()
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }
    }
}
