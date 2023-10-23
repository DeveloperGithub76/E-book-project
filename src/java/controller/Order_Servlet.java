/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BookOrderDAO;
import DAO.BookOrderDAOImpl;
import DAO.CartDAOImpl;
import dto.Bookdtls;
import dto.Bookorders;
import dto.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@WebServlet("/order")
public class Order_Servlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            HttpSession session=request.getSession();
            int id=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("username");
            String email=request.getParameter("email");
            String phno=request.getParameter("phno");
            String address=request.getParameter("address");
            String landmark=request.getParameter("landmark");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String pincode=request.getParameter("pincode");
            String paymentType=request.getParameter("payment");
            String fullAdd=address+","+landmark+","+city+","+state+","+pincode; 
             
//            System.out.println(name+" "+email+" "+phno+" "+fullAdd+" "+paymentType);
             CartDAOImpl dao=new CartDAOImpl(db.DBconnector.getConnection());
             
            List<Cart> blist= dao.getBookByUser(id);
            if(blist.isEmpty())
            { 
                session.setAttribute("failedMsg","Add Item");
                response.sendRedirect("cart.jsp");
            }else
            {
                BookOrderDAOImpl dao2=new BookOrderDAOImpl(db.DBconnector.getConnection());
          
            Bookorders o=null;
            
            ArrayList<Bookorders> orderList=new ArrayList<Bookorders>();
            Random r=new Random();
            for(Cart c:blist)
            {
               o= new Bookorders();
               o.setOrderId("Book-ORD-00"+r.nextInt(1000));
               o.setUserName(name);
               o.setEmail(email);
               o.setPhno(phno);
               o.setFulladd(fullAdd);
               o.setBookName(c.getBookname());
               o.setAuthor(c.getAuthor());
               o.setPrice(c.getPrice()+"");
               o.setPatmentType(paymentType);
               orderList.add(o);
             
//                System.out.println(c.getBookname()+" "+c.getAuthor()+" "+c.getPrice());
            }
            
           if("noselect".equals(paymentType))
           {
               session.setAttribute("failedMsg","Choose Payment Method");
               response.sendRedirect("cart.jsp");
           }
           else{
              boolean f= dao2.saveOrderNo(orderList);
              if(f)
              {
                  response.sendRedirect("order_success.jsp");
                 
              }
              else{
               session.setAttribute("failedMsg","Your Oder Failed");
               response.sendRedirect("cart.jsp");
              }
           }
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
