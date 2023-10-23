/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.userdtls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.catalina.User;

/**
 *
 * @author sunil
 */
public class UserDAOImpl implements UserDAO
{
   private Connection con;
   public UserDAOImpl(Connection con)
   {
       super();
       this.con=con;
   }
   
    public boolean userRegister(userdtls us) {
     boolean f=false;
        
        try {
            String query = "insert into Users(name, email, phno, password) values(?, ?, ?, ?)"; 
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno()); 
            ps.setString(4, us.getPassword());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

  
    public userdtls login(String email, String password) {
       userdtls us=null;
        try {
            String query="select * from Users where email=? and password=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                us=new userdtls();
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setEmail(rs.getString(3));
                us.setPassword(rs.getString(4));
                us.setPhno(rs.getString(5)); 
                us.setAddress(rs.getString(6));
                us.setLandmark(rs.getString(7));
                us.setCity(rs.getString(8));
                us.setState(rs.getString(9));
                us.setPincode(rs.getString(10));
               
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public boolean checkPassword(int id,String ps)
    {
      boolean f=false;
        try {
            String query="select * from users where id=? and password=?";
            PreparedStatement pst =con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, ps);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
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
    public boolean updateProfile(userdtls us) {
       boolean f=true;
        try {
              String query="update users set  name=?,email=?,phno=? where id=?";
              PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1,us.getName());
           ps.setString(2,us.getEmail());
           ps.setString(3,us.getPhno() );
           ps.setInt(4,us.getId());
           int i=ps.executeUpdate();
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
    public boolean checkUser(String em) {
      boolean f=true;
        try {
           String query="select * from users where email=?";
           PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1, em);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               f=false;
           }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return f;
    }
    
    
}
