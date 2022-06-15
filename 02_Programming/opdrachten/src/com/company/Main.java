package com.company;

import com.company.Forrest.Bear;
import com.company.Zoo.Animal;
import com.company.Zoo.Cat;
import com.company.Zoo.Reptile;
import com.company.Zoo.Zoo;
import com.company.blackjack.Game;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Game.singlePlayer();
    }

    private static void Sort() {
        int[] array = {2, 7, 5, 10, 4, 9, 3, 1, 8, 6};
        var changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < array.length - 1; i++) {
                var f = array[i];
                var s = array[i + 1];
                if (f > s) {
                    array[i + 1] = f;
                    array[i] = s;
                    changed = true;
                }
            }
        }
        for (var x : array){
            System.out.println(x);
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

    class TArray {
        Stack<Integer> receiver;
        Stack<Integer> spare;
        Stack<Integer> target;

        private Stack<Integer> newStack(int len) {
            var r = new Stack<Integer>();
            for (var i = 0; i <= len; i++)
                r.push(i);
            return r;
        }
        public TArray(int a, int b, int c) {
            receiver = newStack(a);
            spare = newStack(b);
            target = newStack(c);
        }
    }

    private void Extra() {
        var arr = new TArray(3,4,2);

    }
}

