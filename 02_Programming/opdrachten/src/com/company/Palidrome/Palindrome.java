package com.company.Palidrome;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        for (var x = 0; x <= word.length() / 2; x++)
            if (word.charAt(x) != word.charAt(word.length() - 1 - x))
                return false;
        return true;
    }

    public static int isPalindrome(int width) {
        // 3 -> 999 => 10 ^ 3 - 1
        var result = -1;
        var max = (int) Math.pow(10, width) - 1;
        for (var x = max; x > 0; x--) {
            for (var y = max; y > 0; y--) {
                var num = x * y;
                if (num > result && isPalindrome(""+num))  {
                    result = num;
                }
            }
        }
        return result;
    }

    public static void run() {
        //906609
        Arrays.stream(new int[]{3, 4})
                .mapToObj(x -> x + " = " + isPalindrome(x))
                .forEach(System.out::println);
        Arrays.stream(new String[]{"racecar", "noon", "Alex", "vork"})
                .map(x -> x + " = " + isPalindrome(x))
                .forEach(System.out::println);
    }

    /*vind de grootste palindroom Lager dan een integer * integer
    de integer heeft lengte gelijk aan length
    dus lengte 3 => 99 x 99 of Lager
    niet aan te raden om 5+
    WINNIN/Mi terenobenen met lengte Aww
    int value Length */
}
