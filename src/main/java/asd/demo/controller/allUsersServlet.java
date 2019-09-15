/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;
import asd.demo.model.*;
import asd.demo.model.dao.MongoDBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Calvi
 */
@WebServlet("/allUsersServ")
public class allUsersServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
       MongoDBConnector connector = new MongoDBConnector();
        
       Users userList = connector.getUserList();
       HttpSession session = request.getSession();
       ArrayList<User> users = userList.getList();
       request.setAttribute("Users", users);
       request.getRequestDispatcher("allUsers.jsp").forward(request, response);
   }
}

