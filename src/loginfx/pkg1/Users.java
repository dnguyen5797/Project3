/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfx.pkg1;

/**
 *
 * @author User
 */
public class Users {
    String userName;
    String password;
    String FXMLfile;

    public Users(String userName, String password, String FXMLfile) {
        this.userName = userName;
        this.password = password;
        this.FXMLfile = FXMLfile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFXMLfile() {
        return FXMLfile;
    }

    public void setFXMLfile(String FXMLfile) {
        this.FXMLfile = FXMLfile;
    }
    
    @Override
    public String toString() {
        //change to only print name "," number "," get rid of strings in it
        return "Users :   " + userName + ":" 
                + password + ":" + 
                FXMLfile;
    }
    public boolean userCheck(String input){
        return input.equals(userName);
    }
    public boolean passCheck(String input){
        return input.equals(password);
}
}
