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
public class OrderPart {

    private BikePart bp;
    private int newQuantity;
    public OrderPart(BikePart bp, int newQuantity){
        this.bp = bp;
        this.newQuantity = newQuantity;
    }
    public BikePart getOPBP(){
        return bp;
    }
    public int getNewQuantity(){
        return newQuantity;
    }
    public void setNewQuantity(int newQuantity){
        this.newQuantity = newQuantity;
    }
}
