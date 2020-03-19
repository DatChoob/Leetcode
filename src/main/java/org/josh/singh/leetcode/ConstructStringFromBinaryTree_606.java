package org.josh.singh.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 606. Construct String from Binary Tree
 * Easy
 * <p>
 * 651
 * <p>
 * 894
 * <p>
 * Add to List
 * <p>
 * Share
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringFromBinaryTree_606 {


    /**
     * Runtime: 6 ms, faster than 76.22% of Java online submissions for Construct String from Binary Tree.
     * Memory Usage: 41.1 MB, less than 26.32% of Java online submissions for Construct String from Binary Tree.
     */
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        StringBuilder builder = new StringBuilder();
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (visited.contains(node)) {
                stack.pop();
                builder.append(")");
            } else {
                visited.add(node);
                builder.append("(").append(node.val);
                if (node.left == null && node.right != null) {
                    builder.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return builder.substring(1, builder.length() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(new ConstructStringFromBinaryTree_606().tree2str(root).equals("1(2(4))(3)"));
    }


}