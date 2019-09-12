/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;
import java.io.Serializable;
import java.util.Comparator;
/**
 *
 * @author Calvin
 */
public class Item implements Serializable{
    
    private String ID;
    private String name;
    private String dateListed;
    private int stock;
    private int soldQuantity;
    private double price;
    private String description;
    private String category;
    private String yearMade;
    private String sellerID;
    private String condition;
    private String color;
    private String image;
    
    public Item(String ID, String name, String dateListed, int stock, int soldQuantity, double price, 
            String description, String category, String yearMade, String sellerID, String condition, String color, String image){
            
        this.ID = ID;
        this.name = name;
        this.dateListed = dateListed;
        this.stock = stock;
        this.soldQuantity = soldQuantity;
        this.price = price;
        this.description = description;
        this.category = category;
        this.yearMade = yearMade;
        this.sellerID = sellerID;
        this.condition = condition;
        this.color = color;
        this.image = image;
    }
    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateListed
     */
    public String getDateListed() {
        return dateListed;
    }

    /**
     * @param dateListed the dateListed to set
     */
    public void setDateListed(String dateListed) {
        this.dateListed = dateListed;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the soldQuantity
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * @param soldQuantity the soldQuantity to set
     */
    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the yearMade
     */
    public String getYearMade() {
        return yearMade;
    }

    /**
     * @param yearMade the yearMade to set
     */
    public void setYearMade(String yearMade) {
        this.yearMade = yearMade;
    }

    /**
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the sellerID
     */
    public String getSellerID() {
        return sellerID;
    }

    /**
     * @param sellerID the sellerID to set
     */
    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
}
