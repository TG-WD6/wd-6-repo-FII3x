package com.company.Functional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class person {
    public String name;
    public int YearOfBirth;
    public String[] Sports;

    public static String[] allSports = new String[]{"paardrijden", "skien", "snowboarden", "voetbal", "tennis", "naar jens luisteren", "zwemmen", "fietsen"};
    public static String[] names = new String[]{"Daan", "Noah", "Lucas", "Sem", "Levi", "Finn", "Milan", "Luuk", "Bram", "Liam", "Jesse", "Mees", "Thomas", "Sam", "Max", "Thijs", "Julian", "Lars", "Adam", "Benjamin", "Noud", "Luca", "Ruben", "Jayden", "James", "Tim", "Stijn", "Gijs", "Siem", "Teun", "Mats", "Hugo", "Jan", "Boaz", "Sven", "Jens", "Mason", "David", "Olivier", "Dex", "Vince", "Guus", "Floris", "Tijn", "Jack", "Ryan", "Cas", "Tygo", "Ties", "Joep", "Daniël", "Tom", "Jurre", "Willem", "Pepijn", "Roan", "Fedde", "Pim", "Jason", "Tobias", "Dean", "Xavi", "Mohamed", "Senn", "Owen", "Quinn", "Morris", "Dani", "Mohammed", "Abel", "Nathan", "Samuel", "Hidde", "Alexander", "Rayan", "Mick", "Niek", "Stan", "Dylan", "Aiden", "Johannes", "Thijmen", "Joshua", "Pieter", "Boris", "Casper", "Jace", "Kai", "Job", "Koen", "Joris", "Jelle", "Sepp", "Jasper", "Jax", "Bas", "Simon", "Stef", "Jip", "Kyan", "Emma", "Julia", "Sophie", "Tess", "Mila", "Anna", "Zoë", "Sara", "Eva", "Lotte", "Evi", "Saar", "Nora", "Lieke", "Lynn", "Fenna", "Olivia", "Fleur", "Liv", "Noor", "Isa", "Yara", "Sarah", "Lisa", "Maud", "Roos", "Nina", "Milou", "Noa", "Elin", "Lauren", "Nova", "Sofie", "Loïs", "Emily", "Esmee", "Sanne", "Lina", "Amy", "Jasmijn", "Hannah", "Feline", "Ella", "Luna", "Femke", "Anne", "Julie", "Sofia", "Maria", "Sophia", "Naomi", "Liz", "Vera", "Fien", "Isabella", "Elise", "Lara", "Lena", "Bo", "Mia", "Charlotte", "Amber", "Floor", "Lizzy", "Norah", "Jill", "Hailey", "Suze", "Fenne", "Iris", "Eline", "Isabel", "Elena", "Veerle", "Benthe", "Tessa", "Evy", "Ivy", "Rosa", "Puck", "Cato", "Fay", "Linde", "Lize", "Lana", "Rosalie", "Hanna", "Laura", "Elif", "Lola", "Merel", "Nikki", "Kiki", "Fiene", "Livia", "Lily", "Johanna", "Romy", "Suus", "Amira"};

    public person(String name, int yearOfBirth, String[] sports) {
        this.name = name;
        YearOfBirth = yearOfBirth;
        Sports = sports;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", YearOfBirth=" + YearOfBirth +
                ", Sports=" + Arrays.toString(Sports) +
                '}';
    }

    public static void run() {
        var rand = new Random();
        var year = LocalDate.now().getYear() - 50;

        var people = IntStream.rangeClosed(0, 100)
                .mapToObj(generatePerson(rand))
                .filter(z -> z.YearOfBirth > year)
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                .map(x -> x.YearOfBirth - year)
                .reduce(0, (a, b) -> a + b);
        System.out.println(people);
    }

    private static IntFunction<person> generatePerson(Random rand) {
        return x -> new person(
                person.names[rand.nextInt(0, person.names.length)],
                rand.nextInt(1952, 2004),
                IntStream.rangeClosed(0, rand.nextInt(1, 5))
                        .mapToObj(y -> person.allSports[rand.nextInt(0, person.allSports.length)])
                        .toArray(String[]::new)
        );
    }
}


