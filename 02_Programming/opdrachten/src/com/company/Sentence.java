package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Sentence extends ISentence {

    public Sentence(String line) {
        super(line);
        count = 0;
        for (var x = 0; x < line.length(); x++) {
            if (line.charAt(x) == '_') count += 1;
        }

    }

    public String askForInput(Scanner scanner) {
        System.out.println("enter " + count + " words.");
        var words = new String[count];
        for (var x = 0; x < count; x++) {
            if (x != 0) System.out.println("input " + (x+1));
            words[x] = scanner.nextLine();
        }
        return with(words);
    }

    public String with(String[] words) {
        if (words.length != count) {
            System.out.println("LOSER!!");
            return "";
        }
        var l = line;
        for (var x = 0; x < count; x++) {
            l = l.replaceFirst("_", words[x]);
        }
        l = (l.charAt(0)+"").toLowerCase(Locale.ROOT) + l.substring(1);
        return l;
    }

    public static void CAH() {
        var random = new Random();
        var scanner = new Scanner(System.in);

        var list = new ISentence[] {
                new Sentence("did you know _ is really _."),
                new Sentence("did you know jens has _?"),
                new Sentence("_ gives me uncontrollable gas."),
                new Sentence("_ is a slippery slope that leads to _."),
                new Sentence("only two things in life are certain death and _."),
                new Sentence("_ + _ = _"),
        };

        do {
            var line = list[random.nextInt(0, list.length)];
            System.out.println(line.askForInput(scanner));
            System.out.println("again y/n");
        } while (scanner.nextLine().charAt(0) == 'y');
    }
}
