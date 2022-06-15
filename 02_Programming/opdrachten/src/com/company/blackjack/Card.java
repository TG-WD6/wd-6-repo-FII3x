package com.company.blackjack;

public class Card {
    public Number number;
    public Kind kind;

    public Card(Number number, Kind kind) {
        this.number = number;
        this.kind = kind;
    }

    public enum Kind {
        hearth, spade, clover, diamond
    }

    public enum Number {
        A, two, three, four, five, six, seven, eight, nine, ten, J, Q, K,
    }

    @Override
    public String toString() {
        String n;
        if (number.ordinal() >= Number.two.ordinal() && number.ordinal() <= Number.ten.ordinal())
            n = number.ordinal() + 1 + "";
        else n = number.toString();
        var k = kind.toString().charAt(0);
        return n + k;
    }
}
