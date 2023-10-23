/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.userdtls;

public interface UserDAO {
    public boolean userRegister(userdtls us);
    public userdtls login(String email,String password);
    
    public boolean checkPassword(int id,String ps);
    
    public boolean updateProfile(userdtls us);
    
    public boolean checkUser(String em);
}
