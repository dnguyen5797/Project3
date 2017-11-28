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
public class ComparatorByPartName implements Comparator<BikePart>{
    
    @Override
    public int compare(BikePart x, BikePart y){
        return x.getPartName().compareTo(y.getPartName());
    }
}
