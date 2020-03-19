package org.josh.singh.leetcode;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * <p>
 * Note:
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {

    /**
     * continuously iterated through string,  if an AdjacentDuplicates is found, we make a new string with the duplicate removed.
     * after some number of iterations, no Adjacent Duplicates  strings will be found
     * <p>
     * O(N*N/2)-> O(N^2)
     *
     * @param S original string
     * @return remaining string with all duplicate strings removed
     */
    public String removeDuplicatesSubStringing(String S) {
        boolean continueNextIteration = true;
        while (continueNextIteration) {
            continueNextIteration = false;
            for (int i = 0; i < S.length() - 1; i++) {
                if (S.charAt(i) == S.charAt(i + 1)) {
                    continueNextIteration = true;
                    S = S.substring(0, i) + S.substring(i + 2);
                }
            }
        }
        return S;
    }


    /**
     * This goes through each character of the string and if it is not the last thing the stack has seen, to dd it, else to remove it from the stack
     * <p>
     * O(N) because only have to iterate through the string once.
     *
     * @param S original string
     * @return remaining string with all duplicate strings removed
     */
    public String removeDuplicatesWithStack(String S) {
        Stack<Character> s = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (!s.empty() && s.peek().equals(c)) {
                s.pop();
            } else {
                s.push(c);
            }
        }

        StringBuilder b = new StringBuilder();
        while (!s.empty()) {
            b.append(s.pop());
        }
        return b.reverse().toString();

    }


}
