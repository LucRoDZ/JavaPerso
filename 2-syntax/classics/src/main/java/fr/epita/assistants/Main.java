package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial(" + n + ") " +
                    "-> Actual: " + Classics.factorial(n) + " Expected: " + expected);

        int n2 = 5;
        long expected2 = 7;
        if (Classics.tribonacci(n2) != expected2)
            System.err.println("Error tribonacci(" + n2 + ") " +
                    "-> Actual: " + Classics.tribonacci(n2) + " Expected: " + expected2);

        String word = "Racecar";
        boolean expected3 = true;
        if (Classics.isPalindrome(word) != expected3)
            System.err.println("Error isPalindrome(\"" + word + "\") " +
                    "-> Actual: " + Classics.isPalindrome(word) + " Expected: " + expected3);

        int[] array = {5, 3, 8, 1, 2};
        int[] expected4 = {1, 2, 3, 5, 8};
        Classics.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != expected4[i]) {
                System.err.println("Error in insertionSort at index " + i);
                break;
            }
        }
        String s1 = "abc";
        String s2 = "defg";
        String expected5 = "adbecfg";
        if (!Classics.combine(s1, s2).equals(expected5))
            System.err.println("Error combine(\"" + s1 + "\", \"" + s2 + "\") " +
                    "-> Actual: " + Classics.combine(s1, s2) + " Expected: " + expected5);
    }
}
