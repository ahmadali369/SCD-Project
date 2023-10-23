
package pl;

import javax.swing.*;

import bll.IBooksBLO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class BooksPO extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel initialPanel;
	private JPanel crudOperationPanel;

	private JPanel inputFieldsPanelForInsertBook;
	private JPanel inputFieldsPanelForEditBook;
	private JPanel inputFieldsPanelForDeleteBook;

	IBooksBLO obj;

	public BooksPO(IBooksBLO obj) {

		this.obj = obj;

		setSize(500, 500);
		setTitle("Encyclopedia Of Arabic Poems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialPanel = new JPanel();
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
		JButton buttonBackcrud = new JButton("<-");

		crudOperationPanel.add(buttonBackcrud);
		crudOperationPanel.add(buttonCreate);
		crudOperationPanel.add(buttonRead);
		crudOperationPanel.add(buttonEdit);
		crudOperationPanel.add(buttonDelete);

		JTextField bookNameTextFieldInsert = new JTextField(20);
		JTextField authorNameTextFieldInsert = new JTextField(20);
		JTextField numOfPoemsTextFieldInsert = new JTextField(5);
		JTextField dateOfBirthAuthorTextFieldInsert = new JTextField(10);
		JTextField dateOfDeathAuthorTextFieldInsert = new JTextField(10);
		JButton buttonBackinsert = new JButton("<-");

		JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backButtonPanel.add(buttonBackinsert);

		JPanel inputFieldsPanelHorizontal = new JPanel(new GridLayout(0, 1));
		inputFieldsPanelHorizontal.add(new JLabel("Book Title: "));
		inputFieldsPanelHorizontal.add(bookNameTextFieldInsert);
		inputFieldsPanelHorizontal.add(new JLabel("Author: "));
		inputFieldsPanelHorizontal.add(authorNameTextFieldInsert);
		inputFieldsPanelHorizontal.add(new JLabel("Number of Poems: "));
		inputFieldsPanelHorizontal.add(numOfPoemsTextFieldInsert);
		inputFieldsPanelHorizontal.add(new JLabel("Date of Birth (Author): "));
		inputFieldsPanelHorizontal.add(dateOfBirthAuthorTextFieldInsert);
		inputFieldsPanelHorizontal.add(new JLabel("Date of Death (Author): "));
		inputFieldsPanelHorizontal.add(dateOfDeathAuthorTextFieldInsert);

		inputFieldsPanelForInsertBook.setLayout(new BoxLayout(inputFieldsPanelForInsertBook, BoxLayout.Y_AXIS));
		inputFieldsPanelForInsertBook.setAlignmentY(TOP_ALIGNMENT);
		inputFieldsPanelForInsertBook.add(backButtonPanel);
		inputFieldsPanelForInsertBook.add(inputFieldsPanelHorizontal);
		inputFieldsPanelForInsertBook.add(buttonInsertBook);

//---------------------

		JTextField bookNameTextFieldEdit = new JTextField(20);
		JTextField authorNameTextFieldEdit = new JTextField(20);
		JTextField numOfPoemsTextFieldEdit = new JTextField(5);
		JTextField dateOfBirthAuthorTextFieldEdit = new JTextField(10);
		JTextField dateOfDeathAuthorTextFieldEdit = new JTextField(10);
		JButton buttonBackedit = new JButton("<-");

		inputFieldsPanelForEditBook.add(buttonBackedit);
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
		JButton buttonBackdel = new JButton("<-");

		inputFieldsPanelForDeleteBook.add(buttonBackdel);
		inputFieldsPanelForDeleteBook.add(new JLabel("Book Title: "));
		inputFieldsPanelForDeleteBook.add(bookNameTextFieldForDelete);
		inputFieldsPanelForDeleteBook.add(new JLabel("Author: "));
		inputFieldsPanelForDeleteBook.add(authorNameTextFieldForDelete);
		inputFieldsPanelForDeleteBook.add(buttonDeleteBook);
		crudOperationPanel.setVisible(false);
		inputFieldsPanelForInsertBook.setVisible(false);
		inputFieldsPanelForEditBook.setVisible(false);
		inputFieldsPanelForDeleteBook.setVisible(false);

		buttonManageBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				initialPanel.setVisible(false);
				crudOperationPanel.setVisible(true);
				add(crudOperationPanel);
			}
		});

		buttonBackcrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crudOperationPanel.setVisible(false);
				initialPanel.setVisible(true);

			}
		});

		buttonBackinsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crudOperationPanel.setVisible(true);
				inputFieldsPanelForInsertBook.setVisible(false);

			}
		});
		buttonBackedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crudOperationPanel.setVisible(true);
				inputFieldsPanelForEditBook.setVisible(false);

			}
		});
		buttonBackdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				inputFieldsPanelForDeleteBook.setVisible(false);
				crudOperationPanel.setVisible(true);

			}
		});

		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crudOperationPanel.setVisible(false);
				inputFieldsPanelForInsertBook.setVisible(true);
				add(inputFieldsPanelForInsertBook);

			}
		});

		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Optional
		scrollPane.setPreferredSize(new Dimension(450, 400)); // Adjust the size as needed

		crudOperationPanel.add(scrollPane);

		buttonRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String, Object>> books = obj.getAllBooks();

				if (books.isEmpty()) {
					System.out.println("No books found in the database.");
				} else {
					listPanel.removeAll(); // Clear the existing list
					for (Map<String, Object> book : books) {
						StringBuilder bookInfo = new StringBuilder();
						bookInfo.append("Book ID: ").append(book.get("bookId")).append("\n");
						bookInfo.append("Title: ").append(book.get("title")).append("\n");
						bookInfo.append("Author: ").append(book.get("authorName")).append("\n");
						bookInfo.append("Date of Birth: ").append(book.get("authorDateOfBirth")).append("\n");
						bookInfo.append("Date of Death: ").append(book.get("authorDateOfDeath")).append("\n");
						bookInfo.append("Total Poems: ").append(book.get("totalPoems")).append("\n");

						bookInfo.append("------------------------------");

						JTextArea bookTextArea = new JTextArea(bookInfo.toString());
						bookTextArea.setWrapStyleWord(true);
						bookTextArea.setLineWrap(true);
						bookTextArea.setOpaque(false);

						bookTextArea.setEditable(false);

						JPanel optionPanel = new JPanel();
						optionPanel.add(new JButton("del"), new JButton("edit"));

						listPanel.add(bookTextArea, optionPanel);
					}
					listPanel.revalidate();
					listPanel.repaint();
				}
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

		buttonInsertBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputFieldsPanelForInsertBook.isVisible()) {

					System.out.println(bookNameTextFieldEdit.getText());
					obj.insertBook(bookNameTextFieldInsert.getText(), authorNameTextFieldInsert.getText(),
							dateOfBirthAuthorTextFieldInsert.getText(), dateOfDeathAuthorTextFieldInsert.getText(),
							Integer.parseInt(numOfPoemsTextFieldInsert.getText()));

					inputFieldsPanelForInsertBook.setVisible(false);
					crudOperationPanel.setVisible(true);
				}
			}
		});

		buttonEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputFieldsPanelForEditBook.isVisible()) {
					try {
						obj.updateBook(bookNameTextFieldEdit.getText(), authorNameTextFieldEdit.getText(),
								bookNameTextFieldEdit.getText(), authorNameTextFieldEdit.getText(),
								dateOfBirthAuthorTextFieldEdit.getText(), dateOfDeathAuthorTextFieldEdit.getText(),
								Integer.parseInt(numOfPoemsTextFieldEdit.getText()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					inputFieldsPanelForEditBook.setVisible(false);
					crudOperationPanel.setVisible(true);
				}
			}
		});

		buttonDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputFieldsPanelForDeleteBook.isVisible()) {

					obj.deleteBook(bookNameTextFieldForDelete.getText(), authorNameTextFieldForDelete.getText());
					inputFieldsPanelForDeleteBook.setVisible(false);
					crudOperationPanel.setVisible(true);
				}
			}
		});

	}

}
