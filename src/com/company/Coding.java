package com.company;

import java.util.*;

public class Coding {
    private String wordToEncode;
    private String encodedWord = "";


    //Constructor
    public Coding (String userInputWord){
        this.wordToEncode = userInputWord.toLowerCase();
    }


    //Function, which get's called to encode the word given in the constructor
    public String encode(){
        ArrayList<HuffmanNode> charsFound = generateCharAppearance();
        generateEncodingsPerLetter(charsFound);
        for(int i = 0; i < charsFound.size();i++){
            System.out.println(charsFound.get(i).getLetter() +":"+ charsFound.get(i).getCoding());
        }
        generateEncodedWord(charsFound);
        return encodedWord;
    }


    //Function to generate the appearance count of each letter and sort the array
    private ArrayList<HuffmanNode> generateCharAppearance(){
        Boolean updatedCount = false;
        ArrayList<HuffmanNode> foundCharsReturn = new ArrayList<HuffmanNode>();
        foundCharsReturn.add(new HuffmanNode(wordToEncode.charAt(0)));
        for(int i = 1; i < this.wordToEncode.length(); i++){
            for(int j = 0; j < foundCharsReturn.size(); j++){
                if(wordToEncode.charAt(i) == foundCharsReturn.get(j).getLetter()){
                    foundCharsReturn.get(j).increaseLetterCount();
                    updatedCount = true;
                    break;
                }
            }
            if(!updatedCount){
                foundCharsReturn.add(new HuffmanNode(wordToEncode.charAt(i)));
            }
            updatedCount = false;
        }
        foundCharsReturn.sort(Comparator.comparing(HuffmanNode::getLetterCount));
        return foundCharsReturn;
    }

    //Function to generate the coding for each letter
    private void generateEncodingsPerLetter(ArrayList<HuffmanNode> sortedChars){
        HuffmanNode leftNode = null,rightNode = null;
        int lettersProcessed = 2;
        ArrayList<HuffmanNode> nodesList = new ArrayList<HuffmanNode>();
        nodesList.add(new HuffmanNode(sortedChars.get(0),sortedChars.get(1)));
        while(nodesList.size() > 1 || lettersProcessed < sortedChars.size()){
            //Determine the left and the right node of the next parent node
            if(lettersProcessed < sortedChars.size() && nodesList.get(0).getLetterCount() > sortedChars.get(lettersProcessed).getLetterCount()){
                leftNode = sortedChars.get(lettersProcessed);
                lettersProcessed++;
            }else{
                leftNode = nodesList.get(0);
                nodesList.remove(0);
            }
            if(lettersProcessed < sortedChars.size() && nodesList.get(0).getLetterCount() > sortedChars.get(lettersProcessed).getLetterCount()){
                rightNode = sortedChars.get(lettersProcessed);
                lettersProcessed++;
            }else{
                rightNode = nodesList.get(0);
                nodesList.remove(0);
            }

            nodesList.add(0,new HuffmanNode(leftNode,rightNode));
            nodesList.sort(Comparator.comparing(HuffmanNode::getLetterCount));
        }
        nodesList.get(0).addCoding("");
    }

    private void generateEncodedWord(ArrayList<HuffmanNode> foundLetters){
        for(char currentChar : this.wordToEncode.toCharArray()){
            for (HuffmanNode foundLetter : foundLetters) {
                if (foundLetter.getLetter() == currentChar) {
                    encodedWord += foundLetter.getCoding();
                    break;
                }
            }
        }
    }

}
