package org.josh.singh.leetcode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class DeleteNodeInABST_450 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
     * Memory Usage: 42.4 MB, less than 6.90% of Java online submissions for Delete Node in a BST.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        //if key is less than root, then the key must be on the left side
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        //if key is greater than root, then the key must be on the right side
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        //if no children, return null
        if (root.left == null && root.right == null)
            return null;
        //if left is null, return right
        if (root.left == null)
            return root.right;
        //if right is null, return left
        if (root.right == null)
            return root.left;

        //find largest value node of the left side and delete it
        TreeNode prev = root.left;
        while (prev.right != null) prev = prev.right;
        deleteNode(root, prev.val);

        //largest node on left side becomes the root
        prev.right = root.right;
        prev.left = root.left;
        return prev;
    }
}
