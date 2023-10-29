package pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePoemsFrame extends JFrame {
    public ManagePoemsFrame() {
        setTitle("Manage Poems");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton insertPoemButton = new JButton("Insert Poem");
        insertPoemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertPoemFrame insertPoemFrame = new InsertPoemFrame();
                insertPoemFrame.setVisible(true);
            }
        });

        JButton importPoemButton = new JButton("Import Poem");
        importPoemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	InsertPoemFrame importPoemFrame = new InsertPoemFrame();
                importPoemFrame.setVisible(true);
            }
        });
        // Add other buttons and functionality as needed
        
        add(insertPoemButton);
        add(importPoemButton );
    }
}
