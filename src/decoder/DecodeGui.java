package decoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecodeGui implements ActionListener {
    private JFrame mainFrame;
    private JLabel descriptionLabelInput;
    private JLabel descriptionTable;
    private JTextField inputField;
    private JButton decodeButton;
    private JButton decodeWithCoding;
    private JTable letterTable;
    private JPanel userInputPanel;
    private JPanel decodeTablePanel;
    private JLabel decodedWord;

    public void generateGui(){
        mainFrame =  new JFrame("Huffman-Coding Decoder");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600,600);
        mainFrame.setLayout(new GridLayout(2,1));

        userInputPanel = new JPanel();
        descriptionLabelInput = new JLabel("Please enter the string do decode");
        userInputPanel.add(descriptionLabelInput);

        inputField = new JTextField(50);
        userInputPanel.add(inputField);

        decodeButton = new JButton("Please press button to decode");
        decodeButton.addActionListener(this);
        decodeButton.setActionCommand("StartDecoding");
        userInputPanel.add(decodeButton);
        mainFrame.add(userInputPanel);

        decodeTablePanel = new JPanel();
        decodeTablePanel.setLayout(new BoxLayout(decodeTablePanel, BoxLayout.Y_AXIS));
        mainFrame.add(decodeTablePanel);

        mainFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("StartDecoding")){
            generateTable(JOptionPane.showInputDialog("Please enter the amount of letters"));
        }else if(actionEvent.getActionCommand().equals("DecodeWithTable")){
            Decoder decoding = new Decoder(inputField.getText());
            decodedWord = new JLabel(decoding.decodeWord(letterTable));
            decodeTablePanel.add(decodedWord);
            mainFrame.revalidate();
        }

    }

    public void generateTable(String numberOfLetters){
        descriptionTable = new JLabel("Please enter the coding in the format: character | encoding");
        decodeTablePanel.add(descriptionTable);
        letterTable = new JTable(Integer.parseInt(numberOfLetters),2);
        decodeTablePanel.add(letterTable);
        decodeWithCoding = new JButton("Decode word with given Table");
        decodeWithCoding.addActionListener(this);
        decodeWithCoding.setActionCommand("DecodeWithTable");
        decodeTablePanel.add(decodeWithCoding);
        mainFrame.revalidate();
    }
}
