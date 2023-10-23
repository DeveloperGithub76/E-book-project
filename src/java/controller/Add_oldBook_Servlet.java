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
@WebServlet("/add_old_book")
@MultipartConfig
public class Add_oldBook_Servlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
          String bookname=request.getParameter("bookname");
          String author=request.getParameter("author");
          String price=request.getParameter("price");
          String bookCategory="Old";
          String status="Active";
          Part part=request.getPart("photo");
          String fileName=part.getSubmittedFileName();
         String useremail=request.getParameter("user");
 
          Bookdtls b=new Bookdtls(bookname,author,price,bookCategory,status,fileName,useremail);
          BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
          
              boolean f=dao.addBooks(b);
              HttpSession session=request.getSession(true);           
          if(f)
          {
                      String path=getServletContext().getRealPath("")+"book";                     
                      File file=new File(path);       
                      part.write(path + File.separator + fileName);
                       session.setAttribute("succMsg","Book Add Successfully");
                      response.sendRedirect("sell_book.jsp");
                                
          }
          else{
              session.setAttribute("failedMsg","Something wrong on server");
              response.sendRedirect("sell_book.jsp");
          }
        } 
        catch (Exception e) 
       {
            e.printStackTrace();
       }
}
}