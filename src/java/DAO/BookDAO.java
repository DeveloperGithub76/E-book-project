/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import db.DBconnector;
import dto.Bookdtls;
import java.util.List;

/**
 *
 * @author sunil
 */
public interface BookDAO {
    public boolean addBooks(Bookdtls b);
    
    public List<Bookdtls> getAllBooks();
    
    public Bookdtls getBookById(int id);
    
    public boolean updateEditBooks(Bookdtls b);
    
    public boolean deleteBooks(int id);
    
    public List<Bookdtls> getNewBook();
    
    public List<Bookdtls> getRecentBook();
    
    public List<Bookdtls> getOldBooks();
    
    public List<Bookdtls> getAllRecentBook();
    public List<Bookdtls> getAllNewBook();
    public List<Bookdtls> getAllOldBook();
    
    public List<Bookdtls> getBookByOld(String email,String cate);
    
    public boolean OldBookDelete(String email,String cate,int id);
    
    public List<Bookdtls> getBookBySearch(String ch);
    
}
