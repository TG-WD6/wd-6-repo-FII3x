package com.company.Exception.Quiz;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Logger {
    public HashMap<Question, LoggerData[]> data;
    public ArrayList<Question> ordered;

    public Logger() {
        data = new HashMap<>();
        ordered = new ArrayList<>();
    }

    public void add(Question q, LoggerData[] data) {
        this.data.put(q, data);
        ordered.add(q);
    }

    public LoggerData[] get (Question q) {
        return data.get(q);
    }

    public void write(Writer w) throws IOException {
        for (var item : ordered) {
            var d = data.get(item);
            w.write("question:" + item.toString() + "\n");
            w.write(String.join(",", Arrays.stream(d).map(x -> x.player + " had " + x.answer + ":" + x.correct).toList()));
            w.write("\n");
        }
    }


}
