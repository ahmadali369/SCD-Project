package pl;

import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dal.PoemDAO;
import transerObjects.Main;

public class PoemGUI {
    private JFrame frame;
    private JTextField titleField;
    private JTextField verseNumberField;
    private JTextField misra1Field;
    private JTextField misra2Field;
    private JTextField bookIdField;

    public PoemGUI() {
        frame = new JFrame("Arabic Poem Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(6, 3));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField();
        JLabel verseNumberLabel = new JLabel("Verse Number:");
        verseNumberField = new JTextField();
        JLabel misra1Label = new JLabel("Misra 1:");
        misra1Field = new JTextField();
        JLabel misra2Label = new JLabel("Misra 2:");
        misra2Field = new JTextField();
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField();

        JButton insertButton = new JButton("Insert Poem");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPoem();
            }
        });
        JButton importButton = new JButton("Import Poem");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importPoem();
            }
        });

        frame.add(bookIdLabel);
        frame.add(bookIdField);
        frame.add(titleLabel);
        frame.add(titleField);
        frame.add(verseNumberLabel);
        frame.add(verseNumberField);
        frame.add(misra1Label);
        frame.add(misra1Field);
        frame.add(misra2Label);
        frame.add(misra2Field);
        frame.add(insertButton);
        frame.add(importButton);

        frame.setVisible(true);
    }

    private void insertPoem() {
        String title = titleField.getText();
        int verseNumber = Integer.parseInt(verseNumberField.getText());
        String misra1 = misra1Field.getText();
        String misra2 = misra2Field.getText();
        int bookId = Integer.parseInt(bookIdField.getText()); 

        Main poem = new Main();
        poem.setTitle(title);
        poem.setVerseNumber(verseNumber);
        poem.setMisra1(misra1);
        poem.setMisra2(misra2);
        poem.setBookId(bookId); 

        PoemDAO poemDAO = new PoemDAO();

        try {
            poemDAO.savePoem(poem);
            JOptionPane.showMessageDialog(frame, "Poem inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error occurred while inserting poem.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void importPoem() {
    	String file = "Poem.txt";
        List<String> poemTitles = new ArrayList<>();
        List<String[]> poemVerses = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inPoemSection = false;
            String currentTitle = "";
            String currentVerse1 = "";
            String currentVerse2 = "";
            
            int verseNumber = 1; // Initialize verse number
            int bookId = 1;     // Set the book ID as needed

            PoemDAO poemDAO = new PoemDAO();

            while ((line = reader.readLine()) != null) {
                if (line.contains("==========")) {
                    inPoemSection = !inPoemSection;
                    if (!inPoemSection) {
                        if (!currentTitle.isEmpty()) {
                            poemTitles.add(currentTitle);
                            poemVerses.add(new String[]{currentVerse1, currentVerse2});
                            
                            Main poem = new Main();
                            poem.setTitle(currentTitle);
                            poem.setVerseNumber(verseNumber); // Set verse number
                            poem.setMisra1(currentVerse1);
                            poem.setMisra2(currentVerse2);
                            poem.setBookId(bookId);           // Set book ID

                            
                            poemDAO.insertDataFromJTable(poem); // Insert the data into the database

                            currentTitle = "";
                            currentVerse1 = "";
                            currentVerse2 = "";
                            
                            verseNumber++;
                        }
                    }
                } else if (inPoemSection) {
                    if (line.startsWith("[")) {
                        currentTitle = line.substring(1, line.indexOf("]"));
                    } else if (line.startsWith("(")) {
                        String[] parts = line.substring(1, line.length() - 1).split("\\.{3}");
                        if (parts.length >= 1) {
                            currentVerse1 = parts[0];
                        }
                        if (parts.length >= 2) {
                            currentVerse2 = parts[1];
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JFrame frame = new JFrame("POEM DATA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"TITLE", "VERSE_NUMBER", "MISRA 1", "MISRA 2","BOOK_ID" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (int i = 0; i < poemTitles.size(); i++) {
            String title = poemTitles.get(i);
            String[] verse = poemVerses.get(i);
            model.addRow(new String[]{title,"", verse[0], verse[1],""});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(200, 200);
        frame.setSize(800, 400);

		
	}

    private void clearFields() {
        titleField.setText("");
        verseNumberField.setText("");
        misra1Field.setText("");
        misra2Field.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PoemGUI());
        
    }
}
