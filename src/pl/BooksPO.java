
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

	IBooksBLO obj;

	public BooksPO(IBooksBLO obj) {

		this.obj = obj;

		setSize(600, 500);
		setTitle("Encyclopedia Of Arabic Poems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialPanel = new JPanel();
		crudOperationPanel = new JPanel();

		inputFieldsPanelForInsertBook = new JPanel();
		inputFieldsPanelForEditBook = new JPanel();

		JButton buttonManageBooks = new JButton("Manage Books");
		initialPanel.add(buttonManageBooks);
		add(initialPanel);

		JButton buttonCreate = new JButton("Insert Book");
		JButton buttonRead = new JButton("Reload");

		JButton buttonInsertBook = new JButton("Insert");
		JButton buttonEditBook = new JButton("Edit");

		JButton buttonBackcrud = new JButton("<-");

		crudOperationPanel.add(buttonBackcrud);
		crudOperationPanel.add(buttonCreate);
		crudOperationPanel.add(buttonRead);

		JTextField bookNameTextFieldInsert = new JTextField(20);
		JTextField authorNameTextFieldInsert = new JTextField(20);
		JTextField numOfPoemsTextFieldInsert = new JTextField(5);
		JTextField dateOfBirthAuthorTextFieldInsert = new JTextField(10);
		JTextField dateOfDeathAuthorTextFieldInsert = new JTextField(10);
		JButton buttonBackinsert = new JButton("<-");

		JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		backButtonPanel.add(buttonBackinsert);
		backButtonPanel.add(new JLabel("Create Book"));

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

		JTextField bookNameTextFieldEditTemp = new JTextField(20);
		JTextField authorNameTextFieldEditTemp = new JTextField(20);

		JTextField bookNameTextFieldEdit = new JTextField(20);
		JTextField authorNameTextFieldEdit = new JTextField(20);
		JTextField numOfPoemsTextFieldEdit = new JTextField(5);
		JTextField dateOfBirthAuthorTextFieldEdit = new JTextField(10);
		JTextField dateOfDeathAuthorTextFieldEdit = new JTextField(10);
		JButton buttonBackedit = new JButton("<-");

		JPanel backButtonPanelEdit = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backButtonPanelEdit.add(buttonBackedit);
		backButtonPanelEdit.add(new JLabel("Edit Book"));

		JPanel inputFieldsPanelHorizontalEdit = new JPanel(new GridLayout(0, 1));
		inputFieldsPanelHorizontalEdit.add(new JLabel("Update Book Title: "));
		inputFieldsPanelHorizontalEdit.add(bookNameTextFieldEdit);
		inputFieldsPanelHorizontalEdit.add(new JLabel("Update Author: "));
		inputFieldsPanelHorizontalEdit.add(authorNameTextFieldEdit);
		inputFieldsPanelHorizontalEdit.add(new JLabel("Update Number of Poems: "));
		inputFieldsPanelHorizontalEdit.add(numOfPoemsTextFieldEdit);
		inputFieldsPanelHorizontalEdit.add(new JLabel("Update Date of Birth (Author): "));
		inputFieldsPanelHorizontalEdit.add(dateOfBirthAuthorTextFieldEdit);
		inputFieldsPanelHorizontalEdit.add(new JLabel("Update Date of Death (Author): "));
		inputFieldsPanelHorizontalEdit.add(dateOfDeathAuthorTextFieldEdit);

		inputFieldsPanelForEditBook.setLayout(new BoxLayout(inputFieldsPanelForEditBook, BoxLayout.Y_AXIS));
		inputFieldsPanelForEditBook.setAlignmentY(TOP_ALIGNMENT);
		inputFieldsPanelForEditBook.add(backButtonPanelEdit);
		inputFieldsPanelForEditBook.add(inputFieldsPanelHorizontalEdit);
		inputFieldsPanelForEditBook.add(buttonEditBook);

//-------------

		buttonManageBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				initialPanel.setVisible(false);
				crudOperationPanel.setVisible(true);
				add(crudOperationPanel);
			}
		});
//---------------------
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

		// -------------------------

		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crudOperationPanel.setVisible(false);
				inputFieldsPanelForInsertBook.setVisible(true);
				add(inputFieldsPanelForInsertBook);

			}
		});

//-------------------

		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(550, 400));
		crudOperationPanel.add(scrollPane);

		buttonRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String, Object>> books = obj.getAllBooks();

				if (books.isEmpty()) {
					System.out.println("No books found in the database.");
				} else {
					listPanel.removeAll();

					for (Map<String, Object> book : books) {
						StringBuilder bookInfo = new StringBuilder();
						bookInfo.append("Book ID: ").append(book.get("bookId")).append("\n");
						bookInfo.append("Title: ").append(book.get("title")).append("\n");
						bookInfo.append("Author: ").append(book.get("authorName")).append("\n");
						bookInfo.append("Date of Birth: ").append(book.get("authorDateOfBirth")).append("\n");
						bookInfo.append("Date of Death: ").append(book.get("authorDateOfDeath")).append("\n");
						bookInfo.append("Total Poems: ").append(book.get("totalPoems")).append("\n");

						bookInfo.append("----------------");

						JTextArea bookTextArea = new JTextArea(bookInfo.toString());
						bookTextArea.setWrapStyleWord(true);
						bookTextArea.setLineWrap(true);
						bookTextArea.setOpaque(false);
						bookTextArea.setEditable(false);

						JPanel bookPanel = new JPanel();

						// Create "Delete" button
						JButton deleteButton = new JButton("Delete Book");
						deleteButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								obj.deleteBook(book.get("title").toString(), book.get("authorName").toString());

								JFrame frame = new JFrame("TextField Validation");
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.setLayout(new GridLayout(3, 2));

								try {

									obj.deleteBook(book.get("title").toString(), book.get("authorName").toString());
									JOptionPane.showMessageDialog(frame, "Book Deleted Sccessfully.. Please reload",
											"Success", JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(frame, "Something went wrong..", "Error",
											JOptionPane.ERROR_MESSAGE);
									e1.printStackTrace();
								}

							}
						});

						// Create "Edit" button
						JButton editButton = new JButton("Edit Book");
						editButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								crudOperationPanel.setVisible(false);
								inputFieldsPanelForEditBook.setVisible(true);

								bookNameTextFieldEditTemp.setText(book.get("title").toString());
								authorNameTextFieldEditTemp.setText(book.get("authorName").toString());

								add(inputFieldsPanelForEditBook);

							}
						});
						// Create "readP" button
						JButton ReadPoemsButton = new JButton("Read Poems");
						editButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
						JButton addPoemsButton = new JButton("Add Poems");
						editButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
						bookPanel.add(bookTextArea);
						bookPanel.add(ReadPoemsButton);
						bookPanel.add(addPoemsButton);
						bookPanel.add(editButton);
						bookPanel.add(deleteButton);

						listPanel.add(bookPanel);
					}

					listPanel.revalidate();
					listPanel.repaint();
				}
			}
		});

		buttonInsertBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputFieldsPanelForInsertBook.isVisible()) {

					JFrame frame = new JFrame("TextField Validation");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLayout(new GridLayout(3, 2));

					if (bookNameTextFieldInsert.getText().isEmpty() || authorNameTextFieldInsert.getText().isEmpty()
							|| dateOfBirthAuthorTextFieldInsert.getText().isEmpty()
							|| dateOfDeathAuthorTextFieldInsert.getText().isEmpty()
							|| numOfPoemsTextFieldInsert.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {

						try {
							obj.insertBook(bookNameTextFieldInsert.getText(), authorNameTextFieldInsert.getText(),
									dateOfBirthAuthorTextFieldInsert.getText(),
									dateOfDeathAuthorTextFieldInsert.getText(),
									Integer.parseInt(numOfPoemsTextFieldInsert.getText()));

							inputFieldsPanelForInsertBook.setVisible(false);
							crudOperationPanel.setVisible(true);
							JOptionPane.showMessageDialog(frame, "Book Created Sccessfully.. Please reload.", "Success",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(frame, "Please fill in Currect fields", "Error",
									JOptionPane.ERROR_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}
			}
		});

		buttonEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputFieldsPanelForEditBook.isVisible()) {

					JFrame frame = new JFrame("TextField Validation");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLayout(new GridLayout(3, 2));

					if (bookNameTextFieldEdit.getText().isEmpty() || authorNameTextFieldEdit.getText().isEmpty()
							|| dateOfBirthAuthorTextFieldEdit.getText().isEmpty()
							|| dateOfDeathAuthorTextFieldEdit.getText().isEmpty()
							|| numOfPoemsTextFieldEdit.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {

						try {
							obj.updateBook(bookNameTextFieldEditTemp.getText(), authorNameTextFieldEditTemp.getText(),
									bookNameTextFieldEdit.getText(), authorNameTextFieldEdit.getText(),
									dateOfBirthAuthorTextFieldEdit.getText(), dateOfDeathAuthorTextFieldEdit.getText(),
									Integer.parseInt(numOfPoemsTextFieldEdit.getText()));
							inputFieldsPanelForEditBook.setVisible(false);
							crudOperationPanel.setVisible(true);

							JOptionPane.showMessageDialog(frame, "Book Edited Sccessfully... Please reload", "Success",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frame, "Please fill in Currect fields", "Error",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}

					}

				}
			}
		});

	}

}
