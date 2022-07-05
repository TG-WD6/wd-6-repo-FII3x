package com.company.airport.csv;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Optional;

public class Parser {
    public static CSVRow[] Parse(Reader reader) throws IOException {
        var rows = new ArrayList<CSVRow>();
        var parser = new Parser(reader);
        while (!parser.Done()) {
            var line = parser.parseLine();
            if (line != null) {
                rows.add(line.get());
            }
        }
        return rows.toArray(CSVRow[]::new);
    }


    private final char quote = '"';
    private final char seperator = ',';

    private final Reader reader;
    private int line = 0;

    public Parser(Reader reader) throws IOException {
        this.reader = reader;
        next();
    }

    private char current = 'a';

    private char next() throws IOException {
        if (ahead) {
            ahead = false;
            return current;
        }
        var prev = current;
        current = (char) reader.read();
        return prev;
    }

    private boolean ahead = false;
    private char peek() throws IOException {
        current = (char) reader.read();
        ahead = true;
        return current;
    }

    private boolean Done() {
        return current == '\uFFFF';
    }

    private final String emptyString = "";

    private Optional<CSVRow> parseLine() throws IOException {
        if (Done())
            return null;
        var values = new ArrayList<String>();
        values.add(parseValue());
        var emptyCount = 0;
        while (!Done()) {
            if (current == ',') next();
            if (current == '\n') {
                next();
                break;
            }
            var value = parseValue();
            if (value.length() == 0) emptyCount += 1;
            else {
                if (emptyCount > 0) {
                    for (var x = 0; x < emptyCount; x++)
                        values.add(emptyString);
                    emptyCount = 0;
                }
                values.add(value.trim());
            }
        }
        return Optional.of(new CSVRow(values.toArray(String[]::new), line));
    }

    private String parseValue() throws IOException {
        var quoted = current == quote;
        if (quoted) next();
        var builder = new StringBuilder();

        while (!Done()) {
            if (quoted) {
                if (current == quote) {
                    if (peek() == quote)
                        next(); // "" -> skip over first quote
                    else {
                        next();
                        break;
                    }
                }
            } else {
                if (current == seperator) break;
                if (current == '\n') break;
                if (current == '\r' && peek() == '\n') {
                    next();
                    break;
                }
            }
            builder.append(next());
        }
        return builder.toString();
    }
}
