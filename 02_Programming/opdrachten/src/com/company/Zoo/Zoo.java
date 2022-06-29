package com.company.Zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

/*
 * ## **Bonus - Animal Birthdays**
 *
 * Een echt systeem moet natuurlijk goed de datum bijhouden. Als je deze opdracht extra uitdagend wil maken, moet je dit zelf ook kunnen. Onderzoek daarvoor eerst de LocalDate class. De documentatie ervan kan je [hier](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html) vinden.
 *
 * Zorg nu voor het volgende:
 *
 * * Elk dier heeft een eigen verjaardag als LocalDate
 * * De dierentuin houdt de dagen ook bij via een LocalDate.
 * * Een nieuwe method _getBirthdays()_ die een LocalDate als parameter neemt en de jarige dieren van die dag in de terminal print.
 *     * Als er geen dieren jarig zijn, wordt dit ook geprint.
 * * De _newDay()_ method roept nu ook elke dag de _getBirthdays()_ method aan
 * * Voer in je _main()_ method _getBirthdays()_ uit voor elke verjaardag van de dieren in je dierentuin.
 */

public class Zoo {
    private ArrayList<Animal> Animals;
    private LocalDate days;
    private LocalDate start;

    public Zoo() {
        start = LocalDate.now();
        days = start;
    }
    public Zoo(ArrayList<Animal> animals) {
        this();
        Animals = animals;
    }
    public Zoo(Animal[] animals) {
        this();
        Animals = new ArrayList(animals.length);
        for (var x : animals) add(x);
    }

    public void add(Animal animal) {
        Animals.add(animal);
        if (animal.BirthDate == null) {
            animal.BirthDate = days;
        }
    }

    public void remove(Animal animal) {
        Animals.remove(animal);
    }

    public void display() {
        for (var animal : Animals) {
            System.out.println(animal);
        }
    }

    public long time() {
        return DAYS.between (start, days);
    }

    public void increment() {
        days = days.plusDays(1);
    }

    public void newDay(boolean print) {
        increment();
        if (print) System.out.println(days);
        add(new Bird("bird " + days, "forrest"));
        if (print) for (var x : Animals) {
            if (time() % x.Feed == 0) {
                System.out.println(x);
            }
        }
    }

    // one bug the birth date is also a birhday itself
    public void getBirthDays() {
        var list = Animals.stream()
                .filter(x -> x.BirthDate.getDayOfMonth() == days.getDayOfMonth() &&
                             x.BirthDate.getMonthValue() == days.getMonthValue())
                .toArray();
        if (list.length > 0) {
            System.out.println(time() + " " + days);
            Arrays.stream(list).forEach(x -> System.out.println(x));
        }
        newDay(false);
    }


}
