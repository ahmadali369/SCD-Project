package pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.PoemDAO;
import transerObjects.Main;

public class InsertPoemFrame extends JFrame {
    private JTextField titleField;
    private JTextField verseNumberField;
    private JTextField misra1Field;
    private JTextField misra2Field;

    public InsertPoemFrame() {
        setTitle("Insert Poem");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField();
        JLabel verseNumberLabel = new JLabel("Verse Number:");
        verseNumberField = new JTextField();
        JLabel misra1Label = new JLabel("Misra 1:");
        misra1Field = new JTextField();
        JLabel misra2Label = new JLabel("Misra 2:");
        misra2Field = new JTextField();

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPoem();
            }
        });
        
        JButton importButton = new JButton("Import");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importPoem();
            }

        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(verseNumberLabel);
        panel.add(verseNumberField);
        panel.add(misra1Label);
        panel.add(misra1Field);
        panel.add(misra2Label);
        panel.add(misra2Field);

        add(panel, BorderLayout.CENTER);
        add(insertButton, BorderLayout.SOUTH);
    }

    private void insertPoem() {
        String title = titleField.getText();
        int verseNumber = Integer.parseInt(verseNumberField.getText());
        String misra1 = misra1Field.getText();
        String misra2 = misra2Field.getText();

        Main poem = new Main();
        poem.setTitle(title);
        poem.setVerseNumber(verseNumber);
        poem.setMisra1(misra1);
        poem.setMisra2(misra2);

        PoemDAO poemDAO = new PoemDAO();

        try {
            poemDAO.savePoem(poem);
            JOptionPane.showMessageDialog(this, "Poem inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while inserting poem.", "Error", JOptionPane.ERROR_MESSAGE);
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

            while ((line = reader.readLine()) != null) {
                if (line.contains("==========")) {
                    inPoemSection = !inPoemSection;
                    if (!inPoemSection) {
                        if (!currentTitle.isEmpty()) {
                            poemTitles.add(currentTitle);
                            poemVerses.add(new String[]{currentVerse1, currentVerse2});
                            currentTitle = "";
                            currentVerse1 = "";
                            currentVerse2 = "";
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
		
	}

    private void clearFields() {
        titleField.setText("");
        verseNumberField.setText("");
        misra1Field.setText("");
        misra2Field.setText("");
    }
}
