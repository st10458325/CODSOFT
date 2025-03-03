/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame implements ActionListener {

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JLabel image;
    ImageIcon hmImage1;
    ImageIcon hmImage2;
    ImageIcon hmImage3;
    ImageIcon hmImage4;
    ImageIcon hmImage5;
    ImageIcon hmImage6;
    ImageIcon hmImage7;
    JLabel titleLabel;
    JLabel correctWord;
    JButton guessButton;
    JButton retryButton;
    JTextField input;
    int wrongGuess;
    HashSet<Character> guessedLetters;
    String wordToGuess;
    JLabel[] wordLabels;
    

    MyFrame() {
        // Create and configure panels
       // Create the panel
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 300, 500);
        panel1.setLayout(null); // Set layout to null to use absolute positioning

        // Load the image
        hmImage1 = new ImageIcon(getClass().getResource("/HM/hangman1.png"));
        hmImage2 = new ImageIcon(getClass().getResource("/HM/hangman2.png"));
        hmImage3 = new ImageIcon(getClass().getResource("/HM/hangman3.png"));
        hmImage4 = new ImageIcon(getClass().getResource("/HM/hangman4.png"));
        hmImage5 = new ImageIcon(getClass().getResource("/HM/hangman5.png"));
        hmImage6 = new ImageIcon(getClass().getResource("/HM/hangman6.png"));
        hmImage7 = new ImageIcon(getClass().getResource("/HM/hangman7.png"));
        image = new JLabel();
        image.setIcon(hmImage1);

        // Set the position and size of the image (JLabel)
        image.setBounds(0, 0, hmImage1.getIconWidth(), hmImage1.getIconHeight()); // Position the image at (0,0) and size it to the image's width and height

        // Add the image (JLabel) to the panel
        panel1.add(image);


        panel2 = new JPanel();
        panel2.setBounds(300, 0, 400, 150);
        panel2.setLayout(new GridLayout(2, 1)); // Single cell, centers content


        // JLabel
        titleLabel = new JLabel("HEY HangMan");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);   // Center vertically
        panel2.add(titleLabel);
        
        // JLabel
        correctWord = new JLabel("");
        correctWord.setFont(new Font("Arial", Font.PLAIN, 30));
        correctWord.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
        correctWord.setVerticalAlignment(SwingConstants.CENTER);   // Center vertically
        
        

        panel3 = new JPanel();
        panel3.setBounds(300, 150, 400, 250);
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20)); // Use GridLayout for word display
        
        panel4 = new JPanel();
        panel4.setBounds(300, 405, 400, 50);
        panel4.setLayout(new GridLayout (1,1));

        input = new JTextField();
        input.setFont(new Font("Arial", Font.BOLD, 14));
        input.setHorizontalAlignment(JTextField.CENTER);

       
        
        guessButton = new JButton("Enter");
        guessButton.addActionListener(this);
        guessButton.setFocusable(false);
        guessButton.setBackground(Color.black);
        guessButton.setForeground(Color.white);
        
        retryButton = new JButton("Retry");
        retryButton.addActionListener(this);
        retryButton.setFocusable(false);
        retryButton.setBackground(Color.black);
        retryButton.setForeground(Color.white);
        
        
        panel4.add(input);
        panel4.add(guessButton);
        panel4.add(retryButton);

        // Configure frame
        this.setTitle("HangMan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null); // No layout manager
        this.setSize(700, 500);
        this.setLocationRelativeTo(null); // Centers the frame

        // Add panels
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        

        // Start the game
        startGame();

        // Set visible
        this.setVisible(true);
    }

    public String generateText() {
        String[] words = {"hello", "world", "java", "swing", "hangman", "Don Echendu", "Benathi", "Armstrong", "Imraan"};
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    private void checkWord() {
        panel3.removeAll();
        StringBuilder wordDisplay = new StringBuilder();
        

        for (int i = 0; i < wordToGuess.length(); i++) {
            char currentChar = wordToGuess.charAt(i);
            if (guessedLetters.contains(currentChar)) {
                wordDisplay.append(currentChar);
            } else {
                wordDisplay.append("_");
            }
        }

        // Update the word display
        wordLabels = new JLabel[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordLabels[i] = new JLabel(String.valueOf(wordDisplay.charAt(i)));
            wordLabels[i].setFont(new Font("Arial", Font.BOLD, 24));
            panel3.add(wordLabels[i]);
        }


        // Update incorrect guesses counter
        ifWrongGuess();

        // Check for incorrect guesses
        if (!wordDisplay.toString().contains("_")) {
            titleLabel.setText("You Win!");
            guessButton.setEnabled(false);
        }
        panel3.revalidate();
        panel3.repaint();
    }

    private void ifWrongGuess() {
        switch (wrongGuess) {
            
            case 6:
                 correctWord.setText("The word is: " +wordToGuess);
                 titleLabel.setText("Game Over!");
                 panel2.add(correctWord);
                 guessButton.setEnabled(false);
                 image.setIcon(hmImage7);
                break;
            case 5:
                 titleLabel.setText("Mistake 5!");
                 image.setIcon(hmImage6);
                break;
            case 4:
                 titleLabel.setText("Mistake 4!");
                 image.setIcon(hmImage5);
                break;
            case 3:
                 titleLabel.setText("Mistake 3!");
                 image.setIcon(hmImage4);
                break;
            case 2:
                 titleLabel.setText("Mistake 2!");
                 image.setIcon(hmImage3);
                break;
            case 1:
                 titleLabel.setText("Mistake 1!");
                 image.setIcon(hmImage2);
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            String temp = input.getText().toLowerCase();
            if (temp.length() == 1) {
                char guess = temp.charAt(0);
                if (!guessedLetters.contains(guess)) {
                    guessedLetters.add(guess);
                    if (!wordToGuess.contains(String.valueOf(guess))) {
                        wrongGuess++;
                    }
                    checkWord();
                } else {
                    titleLabel.setText("you already tried that one");
                    input.setText("");
                }
                input.setText("");
            } else {
                titleLabel.setText("Enter only 1 letter");
                input.setText("");
            }
        }
        
        if (e.getSource() == retryButton) {
            startGame();
        }
    }

    private void startGame() {
        image.setIcon(hmImage1);
        wrongGuess = 0;
        panel2.remove(correctWord);
        guessedLetters = new HashSet<>();
        wordToGuess = generateText();
        populatePanel();
    }

    private void populatePanel() {
        panel3.removeAll();
        titleLabel.setText("Hangman");
        guessButton.setEnabled(true);
        checkWord();
    }
}
