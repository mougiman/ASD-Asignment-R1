/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Item;
import java.util.Comparator;

/**
 *
 * @author Calvin
 */
public class CustomComparator implements Comparator<Item>{
    @Override
    public int compare(Item thisItem, Item compareItem){
        if(thisItem.getPrice() > compareItem.getPrice()){
            return 1;
        }
        else if(thisItem.getPrice() == compareItem.getPrice()){
            return 0;
        }
        return -1;
    }
}
