package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import java.util.*;
public class BooksDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public void insertBook(String title, String authorName, java.sql.Date authorDateOfBirth, java.sql.Date authorDateOfDeath, int totalPoems, int[] poemIds) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertBookSQL = "INSERT INTO books (title, author_name, author_date_of_birth, author_date_of_death, total_poems) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookSQL, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, authorName);
                preparedStatement.setDate(3, authorDateOfBirth);
                preparedStatement.setDate(4, authorDateOfDeath);
                preparedStatement.setInt(5, totalPoems);
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int bookId = generatedKeys.getInt(1);
                        linkPoemsToBook(bookId, poemIds);
                    }
                }
            }
        }
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
                        book.put("poemIds", getPoemIdsForBook(bookId));
                        return book;
                    }
                }
            }
        }
        return null; // Book not found
    }

    public void updateBook(int bookId, String title, String authorName, java.sql.Date authorDateOfBirth, java.sql.Date authorDateOfDeath, int totalPoems, int[] poemIds) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String updateBookSQL = "UPDATE books SET title = ?, author_name = ?, author_date_of_birth = ?, author_date_of_death = ?, total_poems = ? WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateBookSQL)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, authorName);
                preparedStatement.setDate(3, authorDateOfBirth);
                preparedStatement.setDate(4, authorDateOfDeath);
                preparedStatement.setInt(5, totalPoems);
                preparedStatement.setInt(6, bookId);
                preparedStatement.executeUpdate();
                linkPoemsToBook(bookId, poemIds);
            }
        }
    }

    public void deleteBook(int bookId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String deleteBookSQL = "DELETE FROM books WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBookSQL)) {
                preparedStatement.setInt(1, bookId);
                preparedStatement.executeUpdate();
            }
        }
    }

    public void linkPoemsToBook(int bookId, int[] poemIds) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertLinkSQL = "INSERT INTO book_poem_link (book_id, poem_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertLinkSQL)) {
                for (int poemId : poemIds) {
                    preparedStatement.setInt(1, bookId);
                    preparedStatement.setInt(2, poemId);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
        }
    }

    public List<Integer> getPoemIdsForBook(int bookId) throws SQLException {
        List<Integer> poemIds = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectPoemsSQL = "SELECT poem_id FROM book_poem_link WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectPoemsSQL)) {
                preparedStatement.setInt(1, bookId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        poemIds.add(resultSet.getInt("poem_id"));
                    }
                }
            }
        }
        return poemIds;
    }
}
