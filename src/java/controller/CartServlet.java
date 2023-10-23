/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BookDAOImpl;
import DAO.CartDAOImpl;
import dto.Bookdtls;
import dto.Cart;
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
@WebServlet("/cart")
public class CartServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            
            int bid=Integer.parseInt(request.getParameter("bid"));
            int uid=Integer.parseInt(request.getParameter("uid"));
            
            BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
           Bookdtls b= dao.getBookById(bid);
           
           Cart c=new Cart();
           c.setBid(bid);
           c.setUid(uid);c.setBookname(b.getBookname());
           c.setAuthor(b.getAuthor());
           c.setPrice(Double.parseDouble(b.getPrice()));
           c.setTotal_price(Double.parseDouble(b.getPrice()));
           
           CartDAOImpl dao2=new CartDAOImpl(db.DBconnector.getConnection());
           boolean f=dao2.addCart(c);
           
           HttpSession session=request.getSession();
           if(f)
           {
               session.setAttribute("addCart","Book added to cart");
               response.sendRedirect("all_new_book.jsp");
              
           }
           else{
                session.setAttribute("failed","Something wrong on server");
               response.sendRedirect("all_new_book.jsp");
              
           }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
}