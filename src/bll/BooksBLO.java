package bll;

import java.sql.SQLException;
import java.util.*;

import dal.IBookDAO;

public class BooksBLO implements IBooksBLO {

	IBookDAO obj;

	public BooksBLO(IBookDAO obj) {
		this.obj = obj;

	}

	@Override
	public void insertBook(String title, String authorName, String authorDateOfBirth, String authorDateOfDeath,
			int totalPoems) {
		try {
			obj.insertBook(title, authorName, authorDateOfBirth, authorDateOfDeath, totalPoems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> getAllBooks() {
		try {
			return obj.getAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getBook(int bookId) {
		try {
			return obj.getBook(bookId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(String existingTitle, String existingAuthorName, String newTitle, String newAuthorName,
			String authorDateOfBirth, String authorDateOfDeath, int totalPoems) {
		try {
			obj.updateBook(existingTitle, existingAuthorName, newTitle, newAuthorName, authorDateOfBirth,
					authorDateOfDeath, totalPoems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(String title, String authorName) {
		try {
			obj.deleteBook(title, authorName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}