package com.company.Exception.Quiz;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Question {
    public String question;
    public String[] answers;
    public int correct;

    public Question(String question, String[] answers, int correct) {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }

    @Override
    public String toString() {
        var i = new AtomicInteger();
        var answers = Arrays.stream(this.answers)
                .map((x) -> ((i.getAndIncrement() == correct) ? "+" : "") + x).toList();
        return question + "-> answers: [ " +
                String.join("," , answers) + "]";
    }
}
