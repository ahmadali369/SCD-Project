package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import transerObjects.Main;


public class PoemDAO {
    public void savePoem(Main poem) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBhandler.getConnection();
            String sql = "INSERT INTO poems (title, verse_number, misra1, misra2, book_id) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, poem.getTitle());
            preparedStatement.setInt(2, poem.getVerseNumber());
            preparedStatement.setString(3, poem.getMisra1());
            preparedStatement.setString(4, poem.getMisra2());
            preparedStatement.setInt(5, poem.getBookId());
            preparedStatement.executeUpdate();
        } finally {
            DBhandler.close(connection, preparedStatement);
        }
    }

    public void insertDataFromJTable(Main poem) {
    	 Connection connection = null;
    	 PreparedStatement preparedStatement = null;
        try {
        	connection = DBhandler.getConnection();
           // Connection connection = getConnection(); // Establish your database connection here
        	String sql = "INSERT INTO poems (title, verse_number, misra1, misra2, book_id) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, poem.getTitle());
            preparedStatement.setInt(2, poem.getVerseNumber());
            preparedStatement.setString(3, poem.getMisra1());
            preparedStatement.setString(4, poem.getMisra2());
            preparedStatement.setInt(5, poem.getBookId());
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here
        }
    }

    // Other methods for retrieving poems can be implemented here
}
