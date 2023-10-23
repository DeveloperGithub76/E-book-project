/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Bookorders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunil
 */
public class BookOrderDAOImpl implements BookOrderDAO{
    private Connection con;
    
    public BookOrderDAOImpl(Connection con)
    {
        super();
        this.con=con;
    }

   
    
    @Override
    public boolean saveOrderNo(List<Bookorders> blist) {
       boolean f=false;
        try {
            String query="insert into book_order(order_id,user_name,email,address,phone,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement(query);
            for(Bookorders b:blist)
            {
                ps.setString(1,b.getOrderId());
                ps.setString(2,b.getUserName());
                ps.setString(3,b.getEmail());
                ps.setString(4,b.getFulladd());              
                ps.setString(5,b.getPhno());
                ps.setString(6,b.getBookName());
                ps.setString(7,b.getAuthor());
                ps.setString(8,b.getPrice());
                ps.setString(9,b.getPatmentType());
                ps.addBatch();
            }
            int[] count=ps.executeBatch();
            con.commit();
            f=true;
            con.setAutoCommit(true);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Bookorders> getBook(String email) {
        List<Bookorders> list=new ArrayList<Bookorders>();
        Bookorders o=null;
        
        try {
            String query="select * from book_order where email=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                o=new Bookorders();
                o.setId(rs.getInt(1));
                o.setOrderId(rs.getString(2));
                o.setUserName(rs.getString(3));
                o.setEmail(rs.getString(4));
                o.setFulladd(rs.getString(5));
                o.setPhno(rs.getString(6));
                o.setBookName(rs.getString(7));
                o.setAuthor(rs.getString(8));
                o.setPrice(rs.getString(9));
                o.setPatmentType(rs.getString(10));
                list.add(o);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Bookorders> getAllOrder() {
       List<Bookorders> list=new ArrayList<Bookorders>();
        Bookorders o=null;
        
        try {
            String query="select * from book_order ";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                o=new Bookorders();
                o.setId(rs.getInt(1));
                o.setOrderId(rs.getString(2));
                o.setUserName(rs.getString(3));
                o.setEmail(rs.getString(4));
                o.setFulladd(rs.getString(5));
                o.setPhno(rs.getString(6));
                o.setBookName(rs.getString(7));
                o.setAuthor(rs.getString(8));
                o.setPrice(rs.getString(9));
                o.setPatmentType(rs.getString(10));
                list.add(o);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
}
