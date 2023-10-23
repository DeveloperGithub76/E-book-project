/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAOImpl;
import dto.userdtls;
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

public class Register_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

   
            
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String phno=request.getParameter("phno");
            String password=request.getParameter("password");
            String check=request.getParameter("check");
                
            userdtls us=new userdtls();
            us.setName(name);
            us.setEmail(email);
            us.setPhno(phno);
            us.setPassword(password);
            
            HttpSession session=request.getSession();
            if(check!=null)
            {
            UserDAOImpl dao=new UserDAOImpl(db.DBconnector.getConnection());
             boolean f2=dao.checkUser(email);
             if(f2)
             {
               boolean f=dao.userRegister(us);
            if(f)
            {
               session.setAttribute("succMsg","Registration Successfully");
               response.sendRedirect("register.jsp");
            }
            else{
               session.setAttribute("failedMsg","Something Wrommg on server");
               response.sendRedirect("register.jsp");
            }
             }
             else{
                  session.setAttribute("failedMsg","User Already Exist Try Another Email Id");
               response.sendRedirect("register.jsp");
             }
        }
            else{
                session.setAttribute("failedMsg","Please Agree Terms & Conditions");
               response.sendRedirect("register.jsp");
            }
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
