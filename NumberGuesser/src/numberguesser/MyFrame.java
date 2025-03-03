/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numberguesser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    JPanel northPanel = new JPanel(new BorderLayout());
    JLabel infoLabel;
    JPanel centerPanel;
    JLabel imageLabel;
    JPanel southPanel = new JPanel(new GridLayout(3, 1, 6, 6));
    JPanel row1 = new JPanel();
    ImageIcon image;
    JLabel hintLabel;
    JPanel row2 = new JPanel();
    JLabel guessLabel;
    JTextField textField1;
    JButton button1;
    JPanel row3 = new JPanel();
    JButton button2, button3;
    int numberOfAttemps = 10;
    int numberOfTotalAttempts = 0;
    int scoreOfPlayer = 0;
    String[] levelDifficulty = {"Easy", "Hard", "Extreme", "Impossible"};
    static int levelPicker = 0;
    int rollValue = roll();

    MyFrame() {
        setTitle("Number Guesser");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // North Panel
        infoLabel = new JLabel("Attempts: " + numberOfAttemps + "                          "
                + "Score: " + scoreOfPlayer + "                       "
                + "Difficulty: " + levelDifficulty[levelPicker]);

        northPanel.add(infoLabel, BorderLayout.WEST);
        add(northPanel, BorderLayout.NORTH);

        // Center Panel
        centerPanel = new JPanel(new BorderLayout());imageLabel = new JLabel();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/diceImage.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage);
        imageLabel.setIcon(image);

        centerPanel.add(imageLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // First Row
        hintLabel = new JLabel(" ");
        hintLabel.setBackground(Color.red);
        row1.add(hintLabel);
        southPanel.add(row1);

        // Second Row
        guessLabel = new JLabel("Guess: ");
        textField1 = new JTextField(10);
        button1 = new JButton("Enter");
        row2.add(guessLabel);
        row2.add(textField1);
        row2.add(button1);
        southPanel.add(row2);

        // Third Row
        button2 = new JButton("Give Up");
        button3 = new JButton("Play Again");
        row3.add(button2);
        row3.add(button3);
        southPanel.add(row3);

        add(southPanel, BorderLayout.SOUTH);

        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        setVisible(true);
        resetImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            enterButton();
        }
        if (e.getSource() == button2) {
            giveUpButton();
        }
        if (e.getSource() == button3) {
            playAgainButton();
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    public void enterButton() {
        String valueEntered = textField1.getText().trim();

        if (scoreOfPlayer == 5 || scoreOfPlayer == 10 || scoreOfPlayer == 15 || scoreOfPlayer == 20) {
            if (levelPicker < 3) {
                levelPicker++;
            }
        }

        if (containsLetterOrSpaces(valueEntered)) {
            hintLabel.setText("Invalid input! Enter a number.");
            numberOfTotalAttempts++;
            scoreOfPlayer--;
            updateLabels();
            imageLabel.setIcon(null);
            return;
        }

        try {
            int value = Integer.parseInt(valueEntered);

            if (value < rollValue) {
                hintLabel.setText("Too small! Try again.");
                numberOfAttemps--;
                numberOfTotalAttempts++;
            } else if (value > rollValue) {
                hintLabel.setText("Too big! Try again.");
                numberOfAttemps--;
                numberOfTotalAttempts++;
            } else {
                hintLabel.setText("Correct! The number was " + rollValue);
                rollValue = roll();
                scoreOfPlayer++;
                numberOfAttemps++;
            }

            updateLabels();
            textField1.setText("");

            if (numberOfAttemps == 0 && value != rollValue) {
                hintLabel.setText("Game Over! The number was " + rollValue);
            }

        } catch (NumberFormatException ex) {
            hintLabel.setText("Invalid input! Enter a valid number.");
        }
    }
    
    public static boolean containsLetterOrSpaces(String input) {
        return input.matches(".*[a-zA-Z\\s].*");
    }

    public void giveUpButton() {
        hintLabel.setText("You gave up! The number was " + rollValue);
        textField1.setText("");
        imageLabel.setIcon(null);
        imageLabel.setText("\nScore : " + scoreOfPlayer
            + "\nHighest Difficulty : " + levelDifficulty[levelPicker]
            + "\nNo. Failed Attemps : " + numberOfTotalAttempts);
    }

    public void playAgainButton() {
        rollValue = roll();
        numberOfAttemps = 10;
        textField1.setText("");
        hintLabel.setText("New game started! Make a guess.");
        updateLabels();
        resetImage();
    }

    private void updateLabels() {
        infoLabel.setText("Attempts: " + numberOfAttemps + "                          "
                + "Score: " + scoreOfPlayer + "                       "
                + "Difficulty: " + levelDifficulty[levelPicker]);
    }

    private void resetImage() {
        imageLabel.setIcon(image);
    }

    static int roll() {
        switch (levelPicker) {
            case 0:
                return new Random().nextInt(10) + 1;
            case 1:
                return new Random().nextInt(30) + 1;
            case 2:
                return new Random().nextInt(50) + 1;
            default:
                return new Random().nextInt(100) + 1;
        } 
    }
}