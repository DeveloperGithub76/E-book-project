/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CartDAOImpl;
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
@WebServlet("/remove_book")
public class remove_bookCart extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int bid=Integer.parseInt(request.getParameter("bid"));
        int uid=Integer.parseInt(request.getParameter("uid"));
      int cid=Integer.parseInt(request.getParameter("cid"));
        CartDAOImpl dao=new CartDAOImpl(db.DBconnector.getConnection());
       boolean f= dao.deleteBook(bid,uid,cid);
        HttpSession session=request.getSession();
        
        if(f)
        {
            session.setAttribute("succMsg","Book Remove From Cart");
            response.sendRedirect("cart.jsp");
        }
        else
        {
             session.setAttribute("failedMsg","Something wrong on server");
            response.sendRedirect("cart.jsp");
        }
    }

    
}
