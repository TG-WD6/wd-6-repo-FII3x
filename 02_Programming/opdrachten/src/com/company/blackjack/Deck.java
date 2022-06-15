package com.company.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private ArrayList<Card> Cards;

    public Deck() {
        Cards = new ArrayList<Card>(52);
        for (var kind : Card.Kind.values()) {
            for (var number : Card.Number.values()) {
                Cards.add(new Card(number, kind));
            }
        }
    }

    // dump!
    public void shuffle() {
        var random = new Random();
        for (var i = 0; i < Cards.size() * 2; i++) {
            var a = random.nextInt(0, Cards.size());
            var b = random.nextInt(0, Cards.size());
            if (a != b) {
                var t = Cards.get(a);
                Cards.set(a, Cards.get(b));
                Cards.set(b, Cards.get(a));
            }
        }
    }

    private Random random = new Random();
    public Card draw() {
        var index = random.nextInt(0, Cards.size());
        return Cards.remove(index);
    }

    public ArrayList<Card> draw(int index) {
        var cards = new ArrayList<Card>(index);
        for (var i = 0; i < index; i++)
            cards.add(draw());
        return cards;
    }

}
