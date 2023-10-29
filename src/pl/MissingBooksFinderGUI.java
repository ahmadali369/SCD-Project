package pl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bll.Poem;
import bll.PoemBO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public  class MissingBooksFinderGUI extends JFrame implements GUIInterface{
    private JButton importButton;
    private JTable poemTable;
    private DefaultTableModel tableModel;
    private PoemBO poemBO;

    public MissingBooksFinderGUI() {
        setTitle("Missing Books Finder");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        poemBO = new PoemBO();

        importButton = new JButton("Import Poems");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importPoems();
            }
        });

        poemTable = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"Title", "Content"}, 0);
        poemTable.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(poemTable);

        setLayout(new BorderLayout());
        add(importButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
	public void importPoems() {
       
        List<Poem> poems = poemBO.importPoemsFromTextFile("book_series_with_books.txt");
        tableModel.setRowCount(0);
        for (Poem poem : poems) {
            tableModel.addRow(new Object[]{poem.getTitle(), poem.getVerse1(), poem.getVerse2()});
        }
    }

    @Override
    public void displayPoems(List<Poem> poems) {
        // Implementation for displaying poems in the table
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MissingBooksFinderGUI gui = new MissingBooksFinderGUI();
                gui.setVisible(true);
            }
        });
    }
}
