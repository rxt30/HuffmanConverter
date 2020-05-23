package com.company;

public class HuffmanNode {
    private HuffmanNode leftNode = null;
    private HuffmanNode rightNode = null;
    private int letterCount = 1;
    private String coding;
    private char letter;


    //Constructor
    public HuffmanNode(){}

    public HuffmanNode(HuffmanNode leftNode,HuffmanNode rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        letterCount = leftNode.getLetterCount() + rightNode.getLetterCount();
    }
    public HuffmanNode(char letter){
        this.letter = letter;
    }


    //Setter
    public void setLetter(char letter){ this.letter = letter; }
    public void setLetterCount(int lettercount){
        this.letterCount = lettercount;
    }
    public void setLeftNode(HuffmanNode leftNode){this.leftNode = leftNode;}
    public void setRightNode(HuffmanNode rightNode){this.rightNode = rightNode;}


    //Getter
    public char getLetter() {
        return letter;
    }
    public int getLetterCount(){
        return letterCount;
    }
    public String getCoding(){
        return this.coding;
    }
    public HuffmanNode getLeftNode(){return this.leftNode;}
    public HuffmanNode getRightNode(){return this.rightNode;}

    //Methods
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
