package org.josh.singh.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree_297 {
    /**
     * Runtime: 12 ms, faster than 64.35% of Java online submissions for Serialize and Deserialize Binary Tree.
     * Memory Usage: 43.6 MB, less than 15.24% of Java online submissions for Serialize and Deserialize Binary Tree.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        // we want to use pre-order traversal
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                builder.append(node.val);
                stack.push(node.right);
                stack.push(node.left);
            } else builder.append("X");
            if (!stack.empty()) builder.append(",");
        }
        return builder.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String s = queue.poll();
        if (s == null || s.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }

}
