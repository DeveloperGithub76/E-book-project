/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BookDAOImpl;
import dto.Bookdtls;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
public class editBook_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      response.sendRedirect("./admin/edit_books.jsp");
    }
    
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
          int id=Integer.parseInt(request.getParameter("id"));
          String bookname=request.getParameter("bookname");
          String author=request.getParameter("author");
          String price=request.getParameter("price");
          String status=request.getParameter("status");
          
          Bookdtls b=new Bookdtls();
          b.setBookId(id);
          b.setBookname(bookname);
          b.setAuthor(author);
          b.setPrice(price);
          b.setStatus(status);
          
            BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
          boolean f= dao.updateEditBooks(b);
            HttpSession session=request.getSession();
          if(f)
          {
              session.setAttribute("succMsg","Book Update Successfully..");
              response.sendRedirect("admin/all_books.jsp");
          }
          else
          {
              session.setAttribute("failedMsg","Something wrong on server..");
              response.sendRedirect("admin/edit_books.jsp");
          }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
    }
    
    
      
}
