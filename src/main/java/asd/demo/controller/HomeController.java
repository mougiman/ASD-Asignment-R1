/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Item;
import asd.demo.model.ItemList;

import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
     

/**
 *
 * @author Calvin
 */


@WebServlet("/home")
public class HomeController extends HttpServlet {
    //Grabs a the matching items from the database and passes the list
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoDBConnector connector = new MongoDBConnector();
        ArrayList<Item> items = new ArrayList<Item>();
        String query = request.getParameter("searchText");
        String searchType = request.getParameter("searchType");
        String err = "";
        if(query != null && query.length() > 0 && request.getParameter("search") != null){
            if(searchType.equals("item")){
                ItemList item = connector.searchItemList(query); //Returns items that has name similar to query
                items = item.getList();
                if(items.isEmpty()){
                   err = ("There are no items that match the name \"" + query + "\"");
                   request.setAttribute("error", err);                   
                }
            }
            else if(searchType.equals("category")){
                ItemList item = connector.searchCategory(query); //Returns items that has name similar to query
                items = item.getList();
                if(items.isEmpty()){
                   err = ("There are no items that match the category \"" + query + "\"");
                   request.setAttribute("error", err);    
                }
            }
        }
        else{
            ItemList item = connector.getItemList();
            items = item.getList();
            if(items.isEmpty()){
                err = ("There are no items to display");
                request.setAttribute("error", err);       
            }
        }
        String isSorted = request.getParameter("sort");
        if(isSorted != null && isSorted.equals("lowToHigh")){
            Collections.sort(items,new CustomComparator());
        }
        else if(isSorted != null && isSorted.equals("highToLow")){
            Collections.sort(items,new CustomComparator());
            Collections.reverse(items);
        }

        request.setAttribute("error", err);       
        request.setAttribute("itemList", items);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}

 
