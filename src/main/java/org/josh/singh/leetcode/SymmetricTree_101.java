package org.josh.singh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
public class SymmetricTree_101 {


    //runtime 2ms  beats 12% of java,  40.6MB beats  71% of java
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root.left);
        queue2.add(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {


            List<TreeNode> additional1 = new ArrayList<>();
            List<TreeNode> additional2 = new ArrayList<>();

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();


                if (node1 == null && node2 == null) continue;
                if (node1 == null ^ node2 == null) return false;
                if (node1.val != node2.val) return false;
                additional1.add(node1.left);
                additional1.add(node1.right);
                additional2.add(node2.right);
                additional2.add(node2.left);

            }
            queue1.addAll(additional1);
            queue2.addAll(additional2);
        }
        return true;
    }
}
