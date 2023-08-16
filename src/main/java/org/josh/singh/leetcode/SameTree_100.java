package org.josh.singh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree_100 {

    //    Runtime 0ms,  39.6MB beats 95.82% of java
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(p);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null ^ node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue1.add(node1.left);
            queue1.add(node1.right);

            queue2.add(node2.left);
            queue2.add(node2.right);

        }
        return true;
    }
}
