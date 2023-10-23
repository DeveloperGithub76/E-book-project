/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import dto.Bookdtls;
import dto.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunil
 */
public class CartDAOImpl implements CartDAO
{
    private Connection con;

     public CartDAOImpl(Connection con)
     {
         this.con=con;
     }
   
    public boolean addCart(Cart c)
    {
        boolean f=false;
        try {
            String query="insert into cart(bid,uid,bookname,author,price,total_price) values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
          
            ps.setInt(1,c.getBid());
            ps.setInt(2,c.getUid());
            ps.setString(3,c.getBookname());
            ps.setString(4,c.getAuthor());         
            ps.setDouble(5,c.getPrice());
            ps.setDouble(6,c.getTotal_price());
           int i= ps.executeUpdate();
           if(i==1)
           {
               f=true;
           }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Cart> getBookByUser(int UserId) {
        List<Cart> list=new ArrayList<Cart>();
        Cart c=null;
        double totalPrice=0;
        try {
            String query="select * from cart where uid=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, UserId);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                c=new Cart();
                c.setCid(rs.getInt(1));
                c.setBid(rs.getInt(2));
                c.setUid(rs.getInt(3));
                c.setBookname(rs.getString(4));
                c.setAuthor(rs.getString(5));
                c.setPrice(rs.getDouble(6));
               totalPrice=totalPrice+rs.getDouble(7);
               c.setTotal_price(totalPrice);
               list.add(c);
            }
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

   
    public boolean deleteBook(int bid,int uid,int cid)
    {
        boolean f=false;
        try {
        String query="delete from cart where bid=? and uid=? and cid=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1, bid);
        ps.setInt(2, uid);
          ps.setInt(3, cid);
       int i= ps.executeUpdate();
       if(i==1)
       {
           f=true;
       }
       
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       
        return f;
    }
    
    
    
}
