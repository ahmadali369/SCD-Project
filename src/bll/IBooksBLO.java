package bll;

import java.util.List;
import java.util.Map;

public interface IBooksBLO {
	 public void insertBook(String title, String authorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems);
	 public List<Map<String, Object>> getAllBooks();
	 public Map<String, Object> getBook(int bookId);
	 public void updateBook(String existingTitle, String existingAuthorName, String newTitle, String newAuthorName, String authorDateOfBirth, String authorDateOfDeath, int totalPoems);
	 public void deleteBook(String title, String authorName);
}
