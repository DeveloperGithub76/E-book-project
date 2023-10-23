/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Cart;
import java.util.List;

/**
 *
 * @author sunil
 */
public interface CartDAO {
      public boolean addCart(Cart c);
      
      public List<Cart> getBookByUser(int UserId);
      
      public boolean deleteBook(int bid,int uid,int cid);
}
