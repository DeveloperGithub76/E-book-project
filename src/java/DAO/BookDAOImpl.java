/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import db.DBconnector;
import dto.Bookdtls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunil
 */
public class BookDAOImpl  implements BookDAO{
  private Connection con;
  
  public BookDAOImpl(Connection con)
  {
      super();
      this.con=con;
  }
   
    public boolean addBooks(Bookdtls b)
    {
        boolean f=false;
        try {
            String query="insert into book_details(bookname,author,price,bookCategory,status,photo,email) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,b.getBookname());
            ps.setString(2,b.getAuthor());
            ps.setString(3,b.getPrice());
            ps.setString(4,b.getBookCategory());
            ps.setString(5,b.getStatus());
            ps.setString(6,b.getPhoto());
            ps.setString(7,b.getEmail());
               
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
    public List<Bookdtls> getAllBooks()
    {
        List<Bookdtls> list=new ArrayList<Bookdtls>();
        Bookdtls b=null;
        try {
            String sql="select * from book_details";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));
                list.add(b);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Bookdtls getBookById(int id) {
      Bookdtls b=null;
        try {
            String query="select * from book_details where bookId=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
       return b;
    }  

    @Override
    public boolean updateEditBooks(Bookdtls b) {
       boolean f=false;
        try {
            String query="update book_details set bookname=?,author=?,price=?,status=? where bookId=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,b.getBookname());
            ps.setString(2,b.getAuthor());
            ps.setString(3,b.getPrice());
            ps.setString(4,b.getStatus());
            ps.setInt(5,b.getBookId());
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
    public boolean deleteBooks(int id) {
     boolean f=false;
        try {
            
            String query="delete from book_details where bookId=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, id);
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
    public List<Bookdtls> getNewBook()
    {
      List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where bookCategory=? and status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1, "New");
           ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            int i=1;
            while(rs.next() && i<=4)
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
                i++;
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }

    @Override
    public List<Bookdtls> getRecentBook() {
      List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
          ps.setString(1,"Active");
            ResultSet rs = ps.executeQuery();
            int i=1;
            while(rs.next() && i<=4)
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
                i++;
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }

    @Override
    public List<Bookdtls> getOldBooks() {
     List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where bookCategory=? and status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1, "Old");
           ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            int i=1;
            while(rs.next() && i<=4)
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
                i++;
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }
     
// user Pannel

    @Override
    public List<Bookdtls> getAllRecentBook() 
    {
      
      List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
          ps.setString(1,"Active");
            ResultSet rs = ps.executeQuery();
           
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
                
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }

    @Override
    public List<Bookdtls> getAllNewBook()
    {
        List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where bookCategory=? and status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1, "New");
           ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
           
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
               
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }

    @Override
    public List<Bookdtls> getAllOldBook() 
    {
       List<Bookdtls> list=new ArrayList<Bookdtls>();
      Bookdtls b=null;
      
        try {
            String query="select * from  book_details where bookCategory=? and status=? order by bookId DESC";
            PreparedStatement ps =con.prepareStatement(query);
           ps.setString(1, "Old");
           ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
                
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
       return list;
    }

    @Override
    public List<Bookdtls> getBookByOld(String email, String cate) 
    {
        List<Bookdtls> list=new ArrayList<Bookdtls>();
        Bookdtls b=null;
        try {
            String query="select * from book_details where bookCategory=? and email=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1,cate);
            ps.setString(2,email);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
      return list;
    }

    @Override
    public boolean OldBookDelete(String email, String cate,int id) {
       boolean f=false;
        try {
            String query="delete from book_details where bookCategory=? and email=? and bookId=?";
             PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1,cate);
            ps.setString(2,email);
            ps.setInt(3, id);
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
    public List<Bookdtls> getBookBySearch(String ch) {
        List<Bookdtls> list=new ArrayList<Bookdtls>();
        Bookdtls b=null;
        try {
            String query="select * from book_details where  bookname like ?  or author like ? or bookCategory like ? and status=?";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1,"%"+ch+"%");
            ps.setString(2,"%"+ch+"%");
             ps.setString(3,"%"+ch+"%");
              ps.setString(4,"Active");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                b=new Bookdtls();
                b.setBookId(rs.getInt(1));
                b.setBookname(rs.getString(2));
                b.setAuthor(rs.getString(3));          
                b.setPrice(rs.getString(4)); 
                b.setBookCategory(rs.getString(5));
                b.setStatus(rs.getString(6));
                b.setPhoto(rs.getString(7));    
                b.setEmail(rs.getString(8));
                list.add(b);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
      return list;
    }
    
    
    
    
}
