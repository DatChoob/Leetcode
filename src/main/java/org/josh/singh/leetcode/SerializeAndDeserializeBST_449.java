package org.josh.singh.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST_449 {

    /**
     * Runtime: 9 ms, faster than 52.84% of Java online submissions for Serialize and Deserialize BST.
     * Memory Usage: 41.3 MB, less than 8.33% of Java online submissions for Serialize and Deserialize BST.
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
