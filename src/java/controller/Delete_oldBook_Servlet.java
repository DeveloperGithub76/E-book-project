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
@WebServlet("/delete_old_book")
public class Delete_oldBook_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            String em=request.getParameter("em");
            int id=Integer.parseInt(request.getParameter("id"));
            BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
            boolean f=dao.OldBookDelete(em,"Old",id);
            
             HttpSession session=request.getSession();
        
        if(f)
        {
            session.setAttribute("succMsg","Old Boook Delete Successfully");
            response.sendRedirect("old_book.jsp");
        }
        else
        {
             session.setAttribute("failedMsg","Something wrong on server");
            response.sendRedirect("old_book.jsp");
        }
        } catch (Exception e) {
        }
    }

   
}
