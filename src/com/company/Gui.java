package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import javax.swing.*;

public class Gui implements ActionListener {
    private JFrame mainWindow;
    private JLabel infoLabel;
    private JTextField inputBox;
    private JButton compressButton;
    private JPanel inputPanel;
    private JPanel resultPanel;

    public void makeWindow(){
        //Working a little bit with building a gui just for fun
        this.mainWindow = new JFrame("Hello World");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(600,600);
        mainWindow.setLayout(new GridLayout(2,1));

        //Adding a Button and a TextField
        inputPanel = new JPanel() ;

        infoLabel = new JLabel("Please enter word to decrypt: ");
        inputPanel.add(infoLabel);

        inputBox = new JTextField(50);
        inputPanel.add(inputBox);

        compressButton = new JButton("Press to create Huffman-Coding");
        compressButton.setSize(mainWindow.getWidth(),20);
        compressButton.addActionListener(this);
        inputPanel.add(compressButton);
        mainWindow.add(inputPanel);


        resultPanel = new JPanel();
        mainWindow.add(resultPanel);

        mainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int i = 1;
        mainWindow.remove(resultPanel);
        resultPanel = new JPanel();
        Coding encodeWord = new Coding(inputBox.getText());
        ArrayList<HuffmanNode> encodedLetters = encodeWord.encode();
        for(HuffmanNode currentLetter: encodedLetters){
            resultPanel.add(new JLabel(currentLetter.getLetter() + " : " + currentLetter.getCoding() + "\n"));
            i++;
        }
        JLabel encodedWord = new JLabel(inputBox.getText() + " : " + encodeWord.getEncodedWord());
        resultPanel.add(encodedWord);
        resultPanel.setLayout(new GridLayout(i,1));
        mainWindow.add(resultPanel);
        mainWindow.revalidate();
    }
}
