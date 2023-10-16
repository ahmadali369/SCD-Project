 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.HashMap;
 import java.util.Map;

 public class BooksDAO{
   private static final String DB_URL = "jdbc:mysql://localhost:3306/nzzbooksfinder";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "";

   public Map<String, Boolean> getAllBooks(String seriesName) {
     Map<String, Boolean> booksInSeries = new HashMap<>();


     return booksInSeries;
   }



   public boolean addBook(String seriesName, String bookName, String authorName){

      return true;
}


public boolean deleteBook(String seriesName, String authorName){


return true;
}

public boolean updateBook(String seriesName, String bookName, String authorName){


  return true;
}


   
   
 }