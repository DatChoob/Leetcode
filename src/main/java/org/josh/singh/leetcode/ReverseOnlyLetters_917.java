package org.josh.singh.leetcode;

import java.util.Stack;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 * <p>
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * <p>
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters_917 {

    /**
     * Runtime: 1 ms, faster than 47.54% of Java online submissions for Reverse Only Letters.
     * Memory Usage: 38.2 MB, less than 8.70% of Java online submissions for Reverse Only Letters.
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder b = new StringBuilder();
        for (Character ch : S.toCharArray()) {
            if (Character.isLetter(ch)) {
                b.append(stack.pop());
            } else b.append(ch);
        }
        return b.toString();
    }
}
