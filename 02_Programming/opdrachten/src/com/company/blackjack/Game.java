package com.company.blackjack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

    private static String cardsString(ArrayList<Card> cards) {
        var builder = new StringBuilder();
        for (var x = 0; x < cards.size()-1; x++) {
            builder.append(cards.get(x) + ", ");
        }
        builder.append(cards.get(cards.size()-1));
        return builder.toString();
    }

    private static int[] cardValue(ArrayList<Card> cards) {
        var hasAce = false;
        var first = 0;
        for (var x : cards) {
            if (x.number == Card.Number.A) {
                if (hasAce) {
                    first += 1;
                }
                hasAce = true;
            }
            else if (x.number == Card.Number.K ||
                     x.number == Card.Number.Q ||
                     x.number == Card.Number.J)
                first += 10;
            else
                first += x.number.ordinal() + 1;
        }
        if (hasAce) {
            return new int[]{first + 1,first + 11};
        } else {
            return new int[] {first};
        }
    }

    private static int cardEValue(ArrayList<Card> cards) {
        var vals = cardValue(cards);
        if (vals.length > 1) {
            if (vals[1] <= 21 && vals[1] > vals[0])
                return vals[1];
        }
        return vals[0];
    }

    private static String cardValueString(ArrayList<Card> cards) {
        var val = cardValue(cards);
        if (val.length > 1) {
            return val[0] + " or " + val[1];
        }
        return val[0] + "";
    }

    public static void replay() throws IOException {
        System.out.println("do you want to play another round? y/n");
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var line = reader.readLine();
        switch (line) {
            case "y":
            case "yes":
                singlePlayer();
                break;
            case "n":
            case "no":
                return;
            default:
                System.out.println("try again idiot");
                replay();
        }
    }

    public static void singlePlayer() {
        var deck = new Deck();

        var dealer = deck.draw(2);
        var player = deck.draw(2);

        System.out.println("dealer cards: " + cardsString(dealer) + " = " + cardValueString(dealer));
        System.out.println("player cards: " + cardsString(player) + " = " + cardValueString(player));

        var reader = new BufferedReader(new InputStreamReader(System.in));

        Loop:
        while (true) {
            try {
            var hand = cardEValue(player);
            if (hand == 21) {
                System.out.println("you win!");
                replay();
                return;
            } else if (hand > 21) {
                System.out.println("you lose!");
                replay();
                return;
            }

            System.out.println("what do you want to do? card or done <- type the command");

                var line = reader.readLine();
                switch (line) {
                    case "card":
                        var card = deck.draw();
                        System.out.println("drawn: " + card);
                        player.add(card);
                        System.out.println("cards " + cardsString(player) + " = " + cardValueString(player));
                                break;
                    case "done":
                        break Loop;
                    default:
                        System.out.println("you can only use 'card' or 'done'");
                        continue;
                }
            } catch(Exception e) {
                System.out.println("loser!!");
                continue ;
            }
        }
        var val = cardEValue(player);
        var dval = cardEValue(dealer);
        if (val > dval && val <= 21) {
            System.out.println("you won!");
        } else {
            System.out.println("you lost!");
        }
        try {
            replay();
        } catch (IOException e) {
            System.out.println("lol");
        }
    }
}
