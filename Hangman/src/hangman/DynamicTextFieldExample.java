/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

/**
 *
 * @author A.TAFA.TATERA
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DynamicTextFieldExample extends JFrame {

    JPanel parentPanel;
    JPanel childPanel;

    public DynamicTextFieldExample() {
        // Configure JFrame
        this.setTitle("Dynamic JTextField Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500); // Fixed size
        this.setLayout(null); // Null layout for precise control

        // Create ParentPanel with GridLayout
        parentPanel = new JPanel(new GridLayout(1, 1)); // Single cell
        parentPanel.setBounds(50, 50, 600, 400); // Position inside JFrame
        parentPanel.setBackground(Color.LIGHT_GRAY);

        // Create ChildPanel with FlowLayout
        childPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        childPanel.setOpaque(false); // Transparent child panel
        parentPanel.add(childPanel);

        // Add ParentPanel to JFrame
        this.add(parentPanel);

        // Populate ChildPanel with JTextFields
        populateTextFields();

        this.setVisible(true);
    }

    private void populateTextFields() {
        // Clear existing components in ChildPanel
        childPanel.removeAll();

        // Generate random number of JTextFields (between 3 and 20)
        Random random = new Random();
        int numTextFields = 13;

        // Add JTextFields to ChildPanel
        for (int i = 0; i < numTextFields; i++) {
            JTextField textField = new JTextField("Field " + (i + 1), 10); // Width = 10 columns
            textField.setFont(new Font("Arial", Font.PLAIN, 14));
            childPanel.add(textField);
        }

        // Ensure UI updates after adding components
        childPanel.revalidate();
        childPanel.repaint();
    }

 
}