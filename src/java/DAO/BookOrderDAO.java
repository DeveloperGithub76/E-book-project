/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Bookorders;
import java.util.List;

/**
 *
 * @author sunil
 */
public interface BookOrderDAO {
  
    
    public boolean saveOrderNo(List<Bookorders> b);
    
    public List<Bookorders> getBook(String email);
    
    //for admin views
     public List<Bookorders> getAllOrder();
}
