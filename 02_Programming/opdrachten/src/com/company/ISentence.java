package com.company;

import java.util.Scanner;

public abstract class ISentence {
    public String line;
    public int count;
    public String[] input;

    public ISentence(String line) {
        this.line = line;
    }

    public abstract String askForInput(Scanner scanner);
}
