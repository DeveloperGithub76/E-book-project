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
@WebServlet("/update_profile")
public class updateProfile_Servlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String phno=request.getParameter("phno");
            String password=request.getParameter("password");
            
            userdtls us=new userdtls();
             us.setId(id);
             us.setName(name);
             us.setEmail(email);
             us.setPhno(phno);
             HttpSession session=request.getSession();
            UserDAOImpl dao=new UserDAOImpl(db.DBconnector.getConnection());
           boolean f=dao.checkPassword(id, password);
            if (f) {
    boolean f2 = dao.updateProfile(us);
    if (f2) {
        session.setAttribute("succMsg", "Profile Update Successfully");
        response.sendRedirect("Edit_profile.jsp");
    } else {
        session.setAttribute("failedMsg", "Something wrong on the server");
        response.sendRedirect("Edit_profile.jsp");
    }
} else {
    session.setAttribute("failedMsg", "Your Password Is Incorrect");
    response.sendRedirect("Edit_profile.jsp");
}

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
