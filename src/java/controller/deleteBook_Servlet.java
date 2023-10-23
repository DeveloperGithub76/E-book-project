/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BookDAOImpl;
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
@WebServlet("/delete")
public class deleteBook_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            
            BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
            boolean f=dao.deleteBooks(id);
            HttpSession session=request.getSession();
          if(f)
          {
             session.setAttribute("succMsg","Book Delete Successfully");
                      response.sendRedirect("admin/all_books.jsp");
          }
          else
          {
               session.setAttribute("failedMsg","Something wrong on server");
                      response.sendRedirect("admin/all_books.jsp");
          }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
