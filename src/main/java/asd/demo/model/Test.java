/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;
import java.io.Serializable;

/**
 *
 * @author Calvi
 */
public class Test implements Serializable{
    private String name = "ahaha";
    private String ID = "02";
    
    public Test(String n, String i){
        this.name = n;
        this.ID = i;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String num(){
        return "aha";
    }
    
    
    
}
