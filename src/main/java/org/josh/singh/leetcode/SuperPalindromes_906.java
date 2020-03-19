package org.josh.singh.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.
 * <p>
 * Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: L = "4", R = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L and R are strings representing integers in the range [1, 10^18).
 * int(L) <= int(R)
 */
public class SuperPalindromes_906 {

    public int superpalindromesInRange(String L, String R) {

        //let i = r  to l
        //if i is a palindrome, and  Math.sqrt(i)  is a palindrome, then increment.
        //store in a set and check if is palindrome

        int low = Integer.parseInt(L);
        int high = Integer.parseInt(R);

        Stack<Integer> stack = new Stack<>();
        Set<Integer> superpalindromes = new HashSet<>();
        for (int i = low; i <= high; i++) {
            if (superpalindromes.contains(i)) continue;
            getSupers(stack, i, superpalindromes, low, high);
            while (!stack.isEmpty()) {
                getSupers(stack, stack.pop(), superpalindromes, low, high);
            }
        }
        return superpalindromes.size();

    }

    private void getSupers(Stack<Integer> stack, int i, Set<Integer> superpalindromes, int low, int high) {
        if (i == 1) {
            superpalindromes.add(i);
            return;
        }
        if (isPalindrome(Integer.toString(i))) {
            double squareRoot = Math.sqrt(i);
            if (Math.floor(squareRoot) == Math.ceil(squareRoot) && isPalindrome(Integer.toString((int) squareRoot))) {
                superpalindromes.add(i);
                if (squareRoot >= low && squareRoot <= high)
                    stack.push((int) squareRoot);
            }
        }
    }

    private boolean isPalindrome(String i) {
        int low = 0;
        int high = i.length() - 1;
        while (low < high) {
            if (i.charAt(low) != i.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new SuperPalindromes_906().superpalindromesInRange("92904622", "232747148"));
        System.out.println((System.nanoTime() - start) / 1000000.0);
    }
}
