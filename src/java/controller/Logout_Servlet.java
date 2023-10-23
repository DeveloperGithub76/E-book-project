/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
@WebServlet("/Logout")
public class Logout_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try
        {
            HttpSession session=request.getSession();
            session.removeAttribute("userobj");
            
            HttpSession session1=request.getSession();
            session.setAttribute("succMsg","Logout Successfully");
            response.sendRedirect("Login.jsp");
        }
        catch (Exception e)
        {
        }
    }

    
}
