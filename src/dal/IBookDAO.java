package dal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IBookDAO {
	 public void insertBook(String title, String authorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems) throws SQLException;
	 public List<Map<String, Object>> getAllBooks() throws SQLException;
	 public Map<String, Object> getBook(int bookId) throws SQLException;
	 public void updateBook(String existingTitle, String existingAuthorName, String newTitle, String newAuthorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems) throws SQLException;
	 public void deleteBook(String title, String authorName) throws SQLException;

}
