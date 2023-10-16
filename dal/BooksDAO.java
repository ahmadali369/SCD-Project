package dal;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.HashMap;
 import java.util.Map;

import  dal.IBookFetcher;
import dal.IBookAdd;
import dal.IBookEdit;




 public class BooksDAO implements IBookFetcher, IBookAdd, IBookEdit{
   private static final String DB_URL = "jdbc:mysql://localhost:3306/nzzbooksfinder";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "";

   @Override
   public Map<String, Boolean> getAllBooks(String seriesName, String authorName) {
     Map<String, Boolean> booksInSeries = new HashMap<>();
System.out.print(1);

     return booksInSeries;
   }

   @Override
   public boolean addBook(String seriesName, String authorName){

      return true;

}


public boolean deleteBook(String seriesName, String authorName){


return true;
}

@Override
public boolean updateBook(String seriesName, String bookName, String authorName){


  return true;
}


   
   
 }