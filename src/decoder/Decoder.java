package decoder;

import com.company.HuffmanNode;

import javax.swing.*;

public class Decoder {
    private String encodedWord;
    private String decodedWord = "";
    private HuffmanNode topParentNode;

    public Decoder(String encodedWord){
        this.encodedWord = encodedWord;
    }

    public String decodeWord(JTable letterTable){
        generateTree(letterTable);
        decodeWordWithTree();
        return decodedWord;
    }

    /*---------------Generating the tree for the decoding--------------*/
    private void generateTree(JTable letterTable){
        topParentNode = new HuffmanNode();
        for(int i = 0; i < letterTable.getRowCount();i++){
            generateNode(this.topParentNode,letterTable.getValueAt(i,0).toString(),letterTable.getValueAt(i,1).toString());
        }
    }

    //The generation of th elinks
    private void generateNode(HuffmanNode currentNode,String letterToSave, String encoding){
        if(encoding.length() == 0){
            currentNode.setLetter(letterToSave.toCharArray()[0]);
        }else{
            if(encoding.charAt(0) == '0'){
                continueLeftNode(currentNode);
                generateNode(currentNode.getLeftNode(),letterToSave,encoding.substring(1));
            }else{
                continueRightNode(currentNode);
                generateNode(currentNode.getRightNode(),letterToSave,encoding.substring(1));
            }
        }
    }

    //Check if leftnode exists
    private void continueLeftNode(HuffmanNode parentNode){
        if(parentNode.getLeftNode() == null){
            parentNode.setLeftNode(new HuffmanNode());
        }
    }

    //Check if Right-Node exists
    private void continueRightNode(HuffmanNode parentNode){
        if(parentNode.getRightNode() == null){
            parentNode.setRightNode(new HuffmanNode());
        }
    }


    /*-------------------Decoding the word----------*/
    private void decodeWordWithTree(){
        while(encodedWord.length() > 0){
            decodedWord += getDecodedChar(this.topParentNode);
        }
    }

    private char getDecodedChar(HuffmanNode currentNode){
        if(currentNode.getRightNode() == null || currentNode.getLeftNode() == null){
            return currentNode.getLetter();
        }else{
            if(encodedWord.charAt(0) == '0'){
                encodedWord = encodedWord.substring(1);
                return getDecodedChar(currentNode.getLeftNode());
            }else{
                encodedWord = encodedWord.substring(1);
                return getDecodedChar(currentNode.getRightNode());
            }
        }
    }

}
