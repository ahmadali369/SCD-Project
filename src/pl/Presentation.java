
package pl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends JFrame {
    private JPanel initialPanel;
    private JPanel manageBooksPanel;
    private JPanel crudOperationPanel;


    private JPanel inputFieldsPanelForInsertBook;
  private JPanel inputFieldsPanelForEditBook;
    private JPanel inputFieldsPanelForDeleteBook;

 
    private List<String> books = new ArrayList<>();

    public Presentation() {
        setSize(500, 500);
        setTitle("Encyclopedia Of Arabic Poems");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initialPanel = new JPanel();
        manageBooksPanel = new JPanel();
        crudOperationPanel = new JPanel();

      
        inputFieldsPanelForInsertBook = new JPanel();
        inputFieldsPanelForEditBook = new JPanel();

      inputFieldsPanelForDeleteBook = new JPanel();

 
        JButton buttonManageBooks = new JButton("Manage Books");
        initialPanel.add(buttonManageBooks);
        add(initialPanel);

        JButton buttonCreate = new JButton("Insert Book");
        JButton buttonRead = new JButton("Read Books");
        JButton buttonEdit = new JButton("Edit Book");
        JButton buttonDelete = new JButton("Delete Book");
 


      JButton buttonInsertBook = new JButton("Insert");  
      JButton buttonEditBook = new JButton("Edit");   
      JButton buttonDeleteBook = new JButton("Delete");  


 
        crudOperationPanel.add(buttonCreate);
        crudOperationPanel.add(buttonRead);
        crudOperationPanel.add(buttonEdit);
        crudOperationPanel.add(buttonDelete);


        JTextField bookNameTextFieldInsert = new JTextField(20);
        JTextField authorNameTextFieldInsert = new JTextField(20);
        JTextField numOfPoemsTextFieldInsert = new JTextField(5);
        JTextField dateOfBirthAuthorTextFieldInsert = new JTextField(10);
        JTextField dateOfDeathAuthorTextFieldInsert = new JTextField(10);

          inputFieldsPanelForInsertBook.add(new JLabel("Book Title: "));
          inputFieldsPanelForInsertBook.add(bookNameTextFieldInsert);
          inputFieldsPanelForInsertBook.add(new JLabel("Author: "));
          inputFieldsPanelForInsertBook.add(authorNameTextFieldInsert);
          inputFieldsPanelForInsertBook.add(new JLabel("Number of Poems: "));
          inputFieldsPanelForInsertBook.add(numOfPoemsTextFieldInsert);
          inputFieldsPanelForInsertBook.add(new JLabel("Date of Birth (Author): "));
          inputFieldsPanelForInsertBook.add(dateOfBirthAuthorTextFieldInsert);
          inputFieldsPanelForInsertBook.add(new JLabel("Date of Death (Author): "));
          inputFieldsPanelForInsertBook.add(dateOfDeathAuthorTextFieldInsert);
          inputFieldsPanelForInsertBook.add(buttonInsertBook);



//---------------------

      JTextField bookNameTextFieldEdit = new JTextField(20);
      JTextField authorNameTextFieldEdit = new JTextField(20);
      JTextField numOfPoemsTextFieldEdit = new JTextField(5);
      JTextField dateOfBirthAuthorTextFieldEdit = new JTextField(10);
      JTextField dateOfDeathAuthorTextFieldEdit = new JTextField(10);

      inputFieldsPanelForEditBook.add(new JLabel("Book Title: "));
      inputFieldsPanelForEditBook.add(bookNameTextFieldEdit);
      inputFieldsPanelForEditBook.add(new JLabel("Author: "));
      inputFieldsPanelForEditBook.add(authorNameTextFieldEdit);
      inputFieldsPanelForEditBook.add(new JLabel("Number of Poems: "));
      inputFieldsPanelForEditBook.add(numOfPoemsTextFieldEdit);
      inputFieldsPanelForEditBook.add(new JLabel("Date of Birth (Author): "));
      inputFieldsPanelForEditBook.add(dateOfBirthAuthorTextFieldEdit);
      inputFieldsPanelForEditBook.add(new JLabel("Date of Death (Author): "));
      inputFieldsPanelForEditBook.add(dateOfDeathAuthorTextFieldEdit);
      inputFieldsPanelForEditBook.add(buttonEditBook);
 
        JTextField bookNameTextFieldForDelete = new JTextField(20);
        JTextField authorNameTextFieldForDelete = new JTextField(20);

      inputFieldsPanelForDeleteBook.add(new JLabel("Book Title: "));
            inputFieldsPanelForDeleteBook.add(bookNameTextFieldForDelete);
        inputFieldsPanelForDeleteBook.add(new JLabel("Author: "));
            inputFieldsPanelForDeleteBook.add(authorNameTextFieldForDelete);
            inputFieldsPanelForDeleteBook.add(buttonDeleteBook);  
        crudOperationPanel.setVisible(false);
          inputFieldsPanelForInsertBook.setVisible(false);
        inputFieldsPanelForEditBook.setVisible(false);
          inputFieldsPanelForDeleteBook.setVisible(false);

        // Add action listeners
        buttonManageBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                initialPanel.setVisible(false);
                crudOperationPanel.setVisible(true);
                add(crudOperationPanel);
            }
        });

        buttonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                crudOperationPanel.setVisible(false);
              inputFieldsPanelForInsertBook.setVisible(true);
                add(inputFieldsPanelForInsertBook);

            }
        });

        buttonRead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                books.clear();
                books.add("Book 1");
                books.add("Book 2");
                books.add("Book 3");

//                createBookButtons();
            }
        });

        buttonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                crudOperationPanel.setVisible(false);
                  inputFieldsPanelForEditBook.setVisible(true);
                add(inputFieldsPanelForEditBook);
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                crudOperationPanel.setVisible(false);
              inputFieldsPanelForDeleteBook.setVisible(true);
                add(inputFieldsPanelForDeleteBook);
            }
        });

        // buttonDone.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         if (crudOperationPanel.isVisible()) {
        //             // Handle "Done" for creating (you can add your logic here)
        //             // Then switch back to the CRUD operation panel
        //               inputFieldsPanelForInsertBook.setVisible(false);
        //             crudOperationPanel.setVisible(true);
        //         } else if (inputFieldsPanelForDeleteBook.isVisible()) {
        //             // Handle "Done" for editing or deleting (you can add your logic here)
        //             // Then switch back to the CRUD operation panel
        //           inputFieldsPanelForDeleteBook.setVisible(false);
        //             crudOperationPanel.setVisible(true);
        //         }
        //     }
        // });

      
        buttonInsertBook.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (inputFieldsPanelForInsertBook.isVisible()) {

                      inputFieldsPanelForInsertBook.setVisible(false);
                  crudOperationPanel.setVisible(true);
              }
          }
      });

      buttonEditBook.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (inputFieldsPanelForEditBook.isVisible()) {

                    inputFieldsPanelForEditBook.setVisible(false);
                crudOperationPanel.setVisible(true);
            }
        }
      });


      buttonDeleteBook.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (inputFieldsPanelForDeleteBook.isVisible()) {

                    inputFieldsPanelForDeleteBook.setVisible(false);
                crudOperationPanel.setVisible(true);
            }
        }
      });



    }


    // private void createBookButtons() {
    //     manageBooksPanel.removeAll();
    //     for (String book : books) {
    //         JButton bookButton = new JButton(book);
    //         manageBooksPanel.add(bookButton);
    //         bookButton.addActionListener(new ActionListener() {
    //             public void actionPerformed(ActionEvent e) {

    //             }
    //         });
    //     }
    //     add(manageBooksPanel);
    //     manageBooksPanel.setVisible(true);
    // }
}






