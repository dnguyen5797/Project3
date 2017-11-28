/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.util.Comparator;


/**
 *
 * @author jarre
 */
public class ComparatorByPartNum implements Comparator<BikePart> {

    @Override
    public int compare(BikePart x, BikePart y) {
        System.out.println("Sorting");
        System.out.println(x.getPartName()+" vs "+y.getPartName());
        int partNum1 = x.getPartNum();
        int partNum2 = x.getPartNum();
        System.out.println(partNum1-partNum2);
        return partNum1-partNum2;
    }
}
