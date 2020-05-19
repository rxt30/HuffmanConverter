package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	System.out.println("Bitte ein Wort zur Codierung eingeben: ");
	String userInputWord = userInput.next();
	Coding codingProcess = new Coding(userInputWord);
	System.out.println("Das kodierte Wort ist: " +codingProcess.encode());
    }
}




