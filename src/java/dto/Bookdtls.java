/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import db.DBconnector;
import java.util.logging.Logger;

/**
 *
 * @author sunil
 */
public class Bookdtls {
    private int bookId;
    private String bookname;
    private String author;
    private String price;
    private String bookCategory;
    private String status;
    private String photo;
    private String email;

public Bookdtls()
{
    super();
}

    public Bookdtls(String bookname, String author, String price, String bookCategory, String status, String photo,String email)
    {
        this.bookId = bookId;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.bookCategory = bookCategory;
        this.status = status;
        this.photo=photo;
        this.email = email;
           }

   
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photoName) {
        this.photo = photoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Bookdtls{" + "bookId=" + bookId + ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", bookCategory=" + bookCategory + ", status=" + status + ", photo=" + photo + ", email=" + email + '}';
    }     
      
}
