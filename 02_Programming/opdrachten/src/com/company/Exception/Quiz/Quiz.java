package com.company.Exception.Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quiz extends Logger {
    public static void Play() {
        var quiz = new Quiz(
            new Question("what is 1 + 1?", new String[] {"1", "2", "3", "4"}, 1),
            new Question("what year was the first iphone released", new String[]{"2005", "2006", "2007", "2008"}, 3)
        );
        quiz.run();

        try {
            var file = new FileWriter("quiz.txt");
            quiz.write(file);
            file.close();
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
    }

    public String[] players;

    private ArrayList<Question> questions;
    private Random random = new Random();
    private Scanner scanner;

    public Quiz(Question... questions) throws IllegalArgumentException {
        super();
        scanner = new Scanner(System.in);

        this.questions = new ArrayList<>(questions.length);
        for (var q : questions) {
            this.questions.add(q);
        }

        System.out.println("met hoeveel spelers?");
        var count = scanner.nextInt();
        if (count > 5) throw new IllegalArgumentException("cant have more than 5 players");
        players = new String[count];

        for (var x = 0; x < count; x++) {
            System.out.println("player "+ (x+1) +" name:");
            players[x] = scanner.next();
        }
    }

    public void run() {
        var index = 1;
        while (questions.size() > 0) {
            System.out.println("round " + index + "!");
            System.out.println("---------------------");
            round();
            index += 1;
        }
    }

    public void round() {
        var q = pick();
        // question:
        System.out.println(q.question);
        for (var x = 0; x < q.answers.length; x++) {
            System.out.println(x + " -> " + q.answers[x]);
        }
        // answer:
        System.out.println("enter the number of the answer per player");
        var data = Arrays.stream(players)
                .map(x -> new LoggerData(x))
                .toArray(LoggerData[]::new);
        for (var d : data) {
            System.out.println(d.player + "?");
            d.answer = getInt(0, q.answers.length);
            d.correct = d.answer == q.correct;
        }
        // print round
        System.out.println("Correct by " +
                String.join(",",
                        Arrays.stream(data)
                                .filter(x -> x.correct)
                                .map(x -> x.player)
                                .toList()));
        add(q, data);
    }

    private Question pick() {
        var rand = random.nextInt(0, questions.size());
        var q = questions.get(rand);
        questions.remove(rand);
        return q;
    }

    private int getInt(int min, int max) {
        while (true) {
            try {
                var i = scanner.nextInt();
                scanner.nextLine();
                if (i >= min || i < max) {
                    return i;
                }
                System.out.println("please enter a number between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("please enter a valid Integer!! " + e.getClass().getName());
                continue;
            }
        }
    }

    @Override
    public void write(Writer w) throws IOException {
        w.write("game played with " + players.length + " players\n");
        w.write(String.join(", ", players) + '\n');
        super.write(w);
    }
}
