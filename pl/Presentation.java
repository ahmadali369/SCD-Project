package pl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Presentation extends JFrame {


  private String bookName;
  private String authorName;
  private int numOfPoems;
  private Date dateOfBirth_author;
  private Date dateOfDeath_author;

  
 private JButton buttonDisplayBooks;
  private JButton buttonAddBook;
private JButton buttonEditBook;
private JButton buttonDeleteBook;



  public Presentation(){
setSize(500,500);
    setTitle("Encyclopedia Of Arabic Poems in the Pre-Islamic Era");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buttonDisplayBooks = new JButton("Display Books");
buttonAddBook = new JButton("Add Book");
buttonEditBook = new JButton("Edit Book");
buttonDeleteBook = new JButton("Delete Book");


buttonDisplayBooks.addActionListener(new ActionListener() {

  public void actionPerformed(ActionEvent e) {
    // Code to display the books
  }
});


buttonAddBook.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    // Code to add a book
  }

});

buttonEditBook.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    // Code to edit a book
  }

});

buttonDeleteBook.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    // Code to delete a book
  }
  
});

    


    
  }



  
}
