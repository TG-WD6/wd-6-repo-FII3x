package com.company.Palidrome;

import java.util.Arrays;

public class Palindrome {
    public static boolean Is(String word) {
        for (var x = 0; x <= word.length() / 2; x++)
            if (word.charAt(x) != word.charAt(word.length() - 1 - x))
                return false;
        return true;
    }

    public static int Is(int width) {
        // 3 -> 999 => 10 ^ 3 - 1
        var maxWidth = (int) Math.pow(10, width) - 1;
        // onder waardes 999 * 999
        var max = (maxWidth * maxWidth);
        // find het grootste nummer
        for (var x = max; x > 0; x--) {
            if (Is(x + ""))
                return x;
        }
        return 0;
    }

    public static void run() {
        //906609
        Arrays.stream(new int[]{3, 4})
                .mapToObj(x -> x + " = " + Is(x))
                .forEach(System.out::println);
        Arrays.stream(new String[]{"racecar", "noon", "Alex", "vork"})
                .map(x -> x + " = " + Is(x))
                .forEach(System.out::println);

    }

    /*vind de grootste palindroom Lager dan een integer * integer
    de integer heeft lengte gelijk aan length
    dus lengte 3 => 99 x 99 of Lager
    niet aan te raden om 5+
    WINNIN/Mi terenobenen met lengte Aww
    int value Length */
}
