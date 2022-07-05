package com.company.Exception.Quiz;

import java.util.Arrays;
import java.util.List;

public class LoggerData {
    public String player;
    public int answer;
    public boolean correct;

    public LoggerData(String player, int answer, boolean correct) {
        this.player = player;
        this.answer = answer;
        this.correct = correct;
    }

    public LoggerData(String player) {
        this.player = player;
    }
}
