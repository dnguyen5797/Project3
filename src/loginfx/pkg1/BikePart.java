/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.util.function.Predicate;

/**
 * Constructs BikePart
 * @author Duy
 */
public class BikePart implements Comparable<BikePart> {

    private String partName;
    private int partNum;
    private double listPrice;
    private double salePrice;
    private boolean onSale;
    private int quantity;
    private int minQuantity;
    /**
     * Constructor
     * @param partName
     * @param partNum
     * @param listPrice
     * @param salePrice
     * @param onSale
     * @param quantity
     */
    public BikePart(String partName, int partNum, double listPrice, double salePrice, boolean onSale, int quantity, int minQuantity) {
        this.partName = partName;
        this.partNum = partNum;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.onSale = onSale;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
    }

    /**
     * Constructor
     * @param partName
     * @param partNum
     * @param listPrice
     * @param salePrice
     * @param onSale
     * @param quantity
     * @param minQuantity
     */
    public BikePart(String partName, int partNum, String listPrice, String salePrice, Boolean onSale, String quantity, String minQuantity) {
        this.partName = partName;
        this.partNum = partNum;
        this.listPrice = Double.parseDouble(listPrice);
        this.salePrice = Double.parseDouble(salePrice);
        this.onSale = onSale;
        this.quantity = Integer.parseInt(quantity);
        this.minQuantity = Integer.parseInt(minQuantity);
    }

    /**
     * Gets the part name
     *
     * @return
     */
    public String getpartName() {
        return partName;
    }

    /**
     * Gets the part number
     *
     * @return
     */
    public int getpartNum() {
        return partNum;
    }

    /**
     * Gets the list price
     *
     * @return
     */
    public double getlistPrice() {
        return listPrice;
    }

    /**
     * Gets the sale price
     *
     * @return
     */
    public double getsalePrice() {
        return salePrice;
    }

    /**
     * Returns a boolean if part is on sale
     *
     * @return
     */
    public boolean getonSale() {
        return onSale;
    }

    /**
     * Returns the quantity that was inputted
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
    public int getminQuantity() {
        return minQuantity;
    }
    /**
     * Sets the quantity
     *
     * @param quantity
     */
    public void quantitySet(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Adds quantity
     * @param quantity
     */
    public void quantityAdd(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Subtracts quantity
     * @param quantity
     */
    public void quantityDel(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Returns either the salePrice or listPrice depending if it is true/false
     *
     * @return
     */
    public double priceGet() {
        if (onSale == true) {
            return salePrice;
        } else {
            return listPrice;
        }
    }

    /**
     * Converts to string
     * @return
     */
    @Override
    public String toString() {
        return partName + "," + partNum + "," + listPrice + "," + salePrice + "," + onSale + "," + quantity;
    }

    /**
     * Sorts part by name
     * @param some
     * @return
     */
    @Override
    public int compareTo(BikePart some) {
        String comparename = ((BikePart) some).getpartName();
        return this.partName.compareTo(comparename);
    }

    static final Predicate<BikePart> invalidQuantity = new Predicate<BikePart>() {
        @Override
        public boolean test(BikePart t) {
            return t.getQuantity() <= 0;
        }
    };
}

