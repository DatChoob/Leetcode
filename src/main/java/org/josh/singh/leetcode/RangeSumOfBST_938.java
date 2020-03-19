package org.josh.singh.leetcode;

import java.util.Stack;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * <p>
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * Note:
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBST_938 {

    /**
     * Runtime: 1 ms, faster than 54.05% of Java online submissions for Range Sum of BST.
     * Memory Usage: 48 MB, less than 79.07% of Java online submissions for Range Sum of BST.
     */
    public int rangeSumBST_recursive_allNodes(TreeNode root, int L, int R) {

        if (root == null)
            return 0;
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST_recursive_allNodes(root.left, L, R) + rangeSumBST_recursive_allNodes(root.right, L, R);
        } else {
            return rangeSumBST_recursive_allNodes(root.left, L, R) + rangeSumBST_recursive_allNodes(root.right, L, R);
        }

    }

    public int rangeSumBST_recursive_pruneNodes(TreeNode root, int L, int R) {

        if (root == null)
            return 0;
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        //if node.val < L, only explore right
        if (root.val > L)
            sum += rangeSumBST_recursive_pruneNodes(root.left, L, R);
        //if node.val >R only explore left
        if (root.val < R)
            sum += rangeSumBST_recursive_pruneNodes(root.right, L, R);
        return sum;
    }

    /**
     * Runtime: 2 ms, faster than 19.84% of Java online submissions for Range Sum of BST.
     * Memory Usage: 48.5 MB, less than 65.70% of Java online submissions for Range Sum of BST.
     */
    public int rangeSumBST_iterative_pruneNodes(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= L && node.val <= R)
                    sum += node.val;
                if (node.val < R)
                    stack.push(node.right);
                if (node.val > L)
                    stack.push(node.left);
            }
        }
        return sum;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
