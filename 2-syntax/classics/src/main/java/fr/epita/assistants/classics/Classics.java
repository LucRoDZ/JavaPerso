package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0) return -1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        long a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            long temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null) return false;
        word = word.replaceAll("\\s", "").toLowerCase();
        return new StringBuilder(word).reverse().toString().equals(word);
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        if (array == null) return;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        if (a == null || b == null) return "";
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            sb.append(a.charAt(i)).append(b.charAt(i));
        }
        sb.append(a.substring(minLength)).append(b.substring(minLength));
        return sb.toString();
    }
}
