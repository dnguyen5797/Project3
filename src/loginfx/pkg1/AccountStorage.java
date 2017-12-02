/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

import java.util.ArrayList;

/**
 *
 * @author Duy
 */
public class AccountStorage {
    
    ArrayList<Accounts> data;
    String name;
    
    public AccountStorage(String name){
        this.name = name;
        this.data = new ArrayList<Accounts>();
    }
    public String getName() {
        return name;
    }

    public ArrayList<Accounts> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "AccountStorage{" + "data=" + data + ", name=" + name + '}';
    }
    
    
}
