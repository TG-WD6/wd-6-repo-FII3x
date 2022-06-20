package com.company;

import java.util.Arrays;
import java.util.Stack;

public class Hanoi {
    private Stack<Integer> source;
    private Stack<Integer> spare;
    private Stack<Integer> destination;

    private int magnitude;
    public int moves = 0;

    public Hanoi(int size) {
        source = new Stack<>();
        spare = new Stack<>();
        destination = new Stack<>();

        for (var x = size; x > 0; x--) {
            source.push(x);
        }

        magnitude = 1;
        while (size >= 10) {
            size /= 10;
            magnitude += 1;
        }
    }

    public void move(Stack<Integer> origin, Stack<Integer> target) {
        var check = origin.size() > 0 && (target.size() == 0 || origin.peek() < target.peek());
        assert !check;
        target.push(origin.pop());

        moves += 1;
        System.out.println("move: " + moves + "");
        System.out.println("------------------------");

        System.out.println(this);


    }

    private String format(Stack<Integer> stack, int index, int length) {
        return format(stack, index, length, false);
    }
    private String format(Stack<Integer> stack, int index, int length, boolean first) {
        var width = first ? length : length + magnitude;
        if (stack.size() > index) {
            var number = stack.get(index);
            var num = (number + "").length();
            if ((length + magnitude) - num > 0) {
                return new String(new char[width-num]).replace('\0', ' ') + number;
            } else {
                return number + "";
            }
        } else {
            return new String(new char[width]).replace('\0', ' ');
        }
    }

    private String[] table() {
        var max = Arrays.stream(new int[]{source.size(), spare.size(), destination.size()})
                .max().getAsInt();
        var result = new String[max];
        for (var x = max-1; x >= 0; x--) {
            var builder = new StringBuilder();
            var spaces = 5;
            builder.append(format(source, x, spaces));
            builder.append(format(spare, x, spaces));
            builder.append(format(destination,x, spaces));
            builder.append("\n");
            result[x] = builder.toString();
        }
        return result;
    }

    public String toString() {
        var builder = new StringBuilder();
        var table = table();
        for (var x = table.length-1; x >= 0; x--)
            builder.append(table[x]);
        builder.append("------------------------");
        return builder.toString();
    }

    private void solve(int disk, Stack<Integer> src, Stack<Integer> dest, Stack<Integer> aux) {
        if (disk == 0) move(src, dest);
        else {
            solve(disk - 1, src, aux, dest);
            move(src, dest);
            solve(disk -1, aux, dest, src);
        }
    }

    public void solve() {
        System.out.println(this);
        while (source.size() > 0) {
            solve(source.peek(), source, destination, spare);
        }
        System.out.println("it took " + moves + " moves!");
    }
}

