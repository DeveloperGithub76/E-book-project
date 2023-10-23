package controller;

import DAO.UserDAOImpl;
import dto.userdtls; 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login_Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAOImpl dao = new UserDAOImpl(db.DBconnector.getConnection());
            HttpSession session = request.getSession();

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if ("sunil@123".equals(email) && "145".equals(password)) {
                userdtls us = new userdtls(); 
                us.setName("Admin");
                session.setAttribute("userobj", us);
                response.sendRedirect("admin/home.jsp");
            } else {
                userdtls us=dao.login(email, password);
              
                if (us != null) {
                    session.setAttribute("userobj", us);
                    response.sendRedirect("index.jsp");
                } else {
                    session.setAttribute("failedMsg", "Email and password invalid");
                    response.sendRedirect("Login.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions here or log them for debugging.
        }
    }
}
