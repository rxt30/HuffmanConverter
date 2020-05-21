package com.company;

public class HuffmanNode {
    private HuffmanNode leftNode = null;
    private HuffmanNode rightNode = null;
    private int letterCount = 1;
    private String coding;
    private char letter;



    public HuffmanNode(){}

    public HuffmanNode(HuffmanNode leftNode,HuffmanNode rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        letterCount = leftNode.getLetterCount() + rightNode.getLetterCount();
    }
    public HuffmanNode(char letter){
        this.letter = letter;
    }


    //Methods
    public char getLetter() {
        return letter;
    }

    public void setLetterCount(int lettercount){
        this.letterCount = lettercount;
    }

    public int getLetterCount(){
        return letterCount;
    }
    public String getCoding(){
        return this.coding;
    }

    public void increaseLetterCount(){
        this.letterCount++;
    }


    public void addCoding(String binaryNumber){
        if(leftNode != null && rightNode != null){
            leftNode.addCoding(binaryNumber + "0");
            rightNode.addCoding(binaryNumber + "1");
        }else{
        coding = binaryNumber;
        }
    }

}
