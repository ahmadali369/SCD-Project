package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import java.util.*;
public class BooksDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/booktestdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";


    
    public void insertBook(String title, String authorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false); 

            String insertBookSQL = "INSERT INTO book (title, author_name, author_date_of_birth, author_date_of_death, total_poems) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookSQL, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, title);
                 preparedStatement.setString(2, authorName);
                preparedStatement.setString(3, authorDateOfBirth);
                preparedStatement.setString(4, authorDateOfDeath);
                preparedStatement.setInt(5, totalPoems);
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int bookId = generatedKeys.getInt(1);

                    }
                }

                connection.commit();
            }
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback(); 
            }
            
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }


    public List<Map<String, Object>> getAllBooks() throws SQLException {
        List<Map<String, Object>> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectAllBooksSQL = "SELECT * FROM book";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllBooksSQL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Map<String, Object> book = new HashMap<>();
                        int bookId = resultSet.getInt("book_id");
                        book.put("bookId", bookId);
                        book.put("title", resultSet.getString("title"));
                        book.put("authorName", resultSet.getString("author_name"));
                        book.put("authorDateOfBirth", resultSet.getString("author_date_of_birth"));
                        book.put("authorDateOfDeath", resultSet.getString("author_date_of_death"));
                        book.put("totalPoems", resultSet.getInt("total_poems"));
//                        book.put("poemIds", getPoemIdsForBook(bookId)); // Assuming you have a getPoemIdsForBook method
                        books.add(book);
                    }
                }
            }
        }

        
        //---------------------------------------------------------------------------------------------------
        
        
        if (books.isEmpty()) {
            System.out.println("No books found in the database.");
        } else {
            for (Map<String, Object> book : books) {
                System.out.println("Book ID: " + book.get("bookId"));
                System.out.println("Title: " + book.get("title"));
                System.out.println("Author: " + book.get("authorName"));
                System.out.println("Date of Birth: " + book.get("authorDateOfBirth"));
                System.out.println("Date of Death: " + book.get("authorDateOfDeath"));
                System.out.println("Total Poems: " + book.get("totalPoems"));
                List<Integer> poemIds = (List<Integer>) book.get("poemIds");
                System.out.println("Poem IDs: " + poemIds);

                System.out.println("------------------------------");
            }
        }
        
        
        
        
        
        return books;
    }

    
    
    public Map<String, Object> getBook(int bookId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectBookSQL = "SELECT * FROM books WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectBookSQL)) {
                preparedStatement.setInt(1, bookId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Map<String, Object> book = new HashMap<>();
                        book.put("bookId", resultSet.getInt("book_id"));
                        book.put("title", resultSet.getString("title"));
                        book.put("authorName", resultSet.getString("author_name"));
                        book.put("authorDateOfBirth", resultSet.getDate("author_date_of_birth"));
                        book.put("authorDateOfDeath", resultSet.getDate("author_date_of_death"));
                        book.put("totalPoems", resultSet.getInt("total_poems"));

                        return book;
                    }
                }
            }
        }
        return null; // Book not found
    }

    public void updateBook(String existingTitle, String existingAuthorName, String newTitle, String newAuthorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String updateBookSQL = "UPDATE book SET title = ?, author_name = ?, author_date_of_birth = ?, author_date_of_death = ?, total_poems = ? WHERE title = ? AND author_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateBookSQL)) {
                preparedStatement.setString(1, newTitle);
                preparedStatement.setString(2, newAuthorName);
                preparedStatement.setString(3, authorDateOfBirth);
                preparedStatement.setString(4, authorDateOfDeath);
                preparedStatement.setInt(5, totalPoems);
                preparedStatement.setString(6, existingTitle);
                preparedStatement.setString(7, existingAuthorName);
                preparedStatement.executeUpdate();

            }
        }
    }


    public void deleteBook(String title, String authorName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String deleteBookSQL = "DELETE FROM book WHERE title = ? AND author_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBookSQL)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, authorName);
                preparedStatement.executeUpdate();
            }
        }
    }


}
