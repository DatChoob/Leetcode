package org.josh.singh.leetcode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves_404 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
     * Memory Usage: 37.6 MB, less than 93.48% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        //if left is a leaf node.
        if (isLeafNode(root.left))
            sum = root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
