/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import DAO.BookDAOImpl;
import dto.Bookdtls;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author sunil
 */

@MultipartConfig
public class Booksadd_servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("./admin/add_books.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
          String bookname=request.getParameter("bookname");
          String author=request.getParameter("author");
          String price=request.getParameter("price");
          String bookCategory=request.getParameter("bookCategory");
          String status=request.getParameter("status");
          Part part=request.getPart("photo");
          String fileName=part.getSubmittedFileName();
          System.out.println(bookname);
 
          Bookdtls b=new Bookdtls(bookname,author,price,bookCategory,status,fileName,"admin");
          BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
          
              boolean f=dao.addBooks(b);
              HttpSession session=request.getSession(true);           
          if(f)
          {
                      String path=getServletContext().getRealPath("")+"book";
//                      System.out.println(path);
                      File file=new File(path);       
                      part.write(path + File.separator + fileName);
                      session.setAttribute("succMsg","Book Add Successfully");
                      response.sendRedirect("admin/add_books.jsp");
                                
          }
          else{
              session.setAttribute("failedMsg","Something wrong on server");
                      response.sendRedirect("admin/add_books.jsp");
          }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

   
}
