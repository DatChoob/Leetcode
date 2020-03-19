package org.josh.singh.leetcode;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 * <p>
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 * <p>
 * Example 1:
 * Input:
 * A binary tree as following:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * Output:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * Example 2:
 * Input:
 * A binary tree as following:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * Output:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class AddOneRowToTree_623 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Add One Row to Tree.
     * Memory Usage: 41.5 MB, less than 14.29% of Java online submissions for Add One Row to Tree.
     */
    //If d ==1, return v as the new root
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode rootNew = new TreeNode(v);
            rootNew.left = root;
            return rootNew;
        }
        return helper(root, v, d - 1);
    }

    /**
     * Editing node connections in-place
     * Decrement til we get to the level just about the depth we want
     * Making a left node in between the current node and it's left node
     * Making a right node in between the current node and it's right node
     */
    private TreeNode helper(TreeNode root, int v, int d) {
        if (root == null)
            return null;
        if (d == 1) {
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = root.left;
            TreeNode newRight = new TreeNode(v);
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
            return root;
        }
        helper(root.left, v, d - 1);
        helper(root.right, v, d - 1);
        return root;
    }
}
