package org.josh.singh.leetcode;

import java.util.Stack;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * Example 1:
 * Input: "())"
 * Output: 1
 * <p>
 * Example 2:
 * Input: "((("
 * Output: 3
 * <p>
 * Example 3:
 * Input: "()"
 * Output: 0
 * <p>
 * Example 4:
 * Input: "()))(("
 * Output: 4
 * <p>
 * <p>
 * Note:
 * S.length <= 1000
 * S only consists of '(' and ')' characters.
 */
public class MinimumAddToMakeParenthesesValid_921 {

    public int minAddToMakeValid(String S) {
        int changes = 0;
        Stack<Character> stack = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c == ')') {
                if (stack.empty()) {
                    changes++;
                } else stack.pop();
            } else stack.push(c);

        }
        return changes + stack.size();
    }

}
