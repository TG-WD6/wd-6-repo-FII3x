package com.company;


import java.util.Scanner;


public class AnnotatedSentence extends Sentence {
    public String[] annotations;

    public AnnotatedSentence(String line) {
        super(line);
    }

    @Override
    public String askForInput(Scanner scanner) {
        if (scanner == null) scanner = new Scanner(System.in);


    }

    public enum Words {

    }

}
