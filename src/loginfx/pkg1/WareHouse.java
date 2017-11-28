/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

/**
 *
 * @author jarre
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class WareHouse {

    ArrayList<BikePart> parts = new ArrayList<BikePart>();
    String wareHouseName;

    public WareHouse(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getName() {
        return wareHouseName;
    }

    public void addPart(BikePart part) {
        theTry:
        try {
            int x = 0;
            while (x < parts.size()) {
                if (parts.get(x).getPartNum() == part.getPartNum()) {
                    parts.get(x).addQuantity(part.getQuantity());
                    parts.get(x).setListPrice(part.getListPrice());
                    parts.get(x).setSale(part.isOnSale());
                    parts.get(x).setSalePrice(part.getSalePrice());
                    break theTry;
                }
                x++;
            }
            if(x == parts.size()){
                parts.add(part);
            }
            System.out.println("Part added.");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public void removePart(BikePart partName, int quantity) {
        try{
        if(parts.contains(partName)){
        for (int x = 0; x < parts.size(); x++) {
            if (parts.get(x).getPartName().equals(partName.getPartName())) {
                parts.get(x).removeQuantity(quantity);
                System.out.println("Quantity decremented.");
                break;
            }
        }
        }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public BikePart sellPart(int num) {
        for (int x = 0; x < parts.size(); x++) {
            if (parts.get(x).getPartNum() == num) {
                parts.get(x).removeQuantity(1);
                System.out.println(parts.get(x).getPartName() + "--" + parts.get(x).getPrice());
                System.out.println(LocalDateTime.now());
                if (parts.get(x).getQuantity() == 0) {
                    BikePart temp = parts.get(x);
                    parts.remove(x);
                    return temp;
                } else {
                    return parts.get(x);
                }
            }
        }
        return null;
    }

    public void displayPart(String name) {
        for (int x = 0; x < parts.size(); x++) {
            if (parts.get(x).getPartName().equals(name)) {
                System.out.println(parts.get(x).getPartName() + "--" + parts.get(x).getPartNum() + "--" + parts.get(x).getPrice() + "--" + parts.get(x).getQuantity());
            }
        }
    }

    public ArrayList<BikePart> getParts() {
        return parts;
    }
    
//    public ArrayList<savedPart> makeSaved() {
//        ArrayList<savedPart> savedList = new ArrayList<savedPart>();
//        for (int x = 0; x < parts.size(); x++) {
//            savedPart temp = new savedPart(parts.get(x), wareHouseName);
//            savedList.add(temp);
//        }
//        return savedList;
//    }
    public void sortName(){
        Collections.sort(parts, new ComparatorByPartName());
    }
    public void sortNum(){
        System.out.println("Starting");
        Collections.sort(parts, new ComparatorByPartNum());
    }
}