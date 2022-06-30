package com.company;

import com.company.Exception.Quiz.Quiz;
import com.company.Forrest.Bear;
import com.company.Functional.person;
import com.company.Palidrome.Palindrome;
import com.company.Zoo.Animal;
import com.company.Zoo.Cat;
import com.company.Zoo.Reptile;
import com.company.Zoo.Zoo;
import com.company.annotations.Weekday;

import java.util.Random;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Palindrome.run();
    }

    private static long measure(int input, Consumer<Integer> action) {
        var time = System.nanoTime();
        action.accept(input);
        return System.nanoTime() - time;
    }

    private static int[] arrayOf(int size) {
        var r = new int[size];
        var random = new Random();
        for (var x = 0; x < size; x++) {
            r[x] = random.nextInt(0, size);
        }
        return r;
    }

    private static void Sort(int size) {
        int[] array = arrayOf(size);
        var changed = true;
        var alen = array.length - 1;

        while (changed) {
            changed = false;
            for (int i = 0; i < alen; i++) {
                var f = array[i];
                var s = array[i + 1];
                if (f > s) {
                    array[i + 1] = f;
                    array[i] = s;
                    changed = true;
                } else if (i == alen - 1) alen -= 1;
            }
        }
    }

    private static void Animals() {
        Animal[] animals = {
            new Cat("jeffy", "huis"),
            new Reptile("eaw", "river")
        };
        var zoo = new Zoo(animals);
        for (var x = 0; x <= 721; x++) {
            zoo.getBirthDays();
        }
    }

    private static void ForrestAnimals() {
        var careBear = new Bear(Bear.Type.Grizzly);
        var bigBear = new Bear(Bear.Type.Black);
    }
}

