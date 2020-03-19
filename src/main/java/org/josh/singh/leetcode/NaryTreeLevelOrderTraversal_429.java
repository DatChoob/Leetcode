package org.josh.singh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * <p>
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
public class NaryTreeLevelOrderTraversal_429 {

    /**
     * Runtime: 4 ms, faster than 20.60% of Java online submissions for N-ary Tree Level Order Traversal.
     * Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for N-ary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder_doublelists(Node root) {

        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> returnlist = new ArrayList<>();
        List<Integer> listByLevel;
        while (!queue.isEmpty()) {
            List<Node> childrenNextLevel = new ArrayList<>();
            listByLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                listByLevel.add(node.val);
                childrenNextLevel.addAll(node.children);
            }
            //specified end of row
            returnlist.add(listByLevel);
            queue.addAll(childrenNextLevel);
        }
        return returnlist;
    }

    /**
     * Runtime: 2 ms, faster than 87.74% of Java online submissions for N-ary Tree Level Order Traversal.
     * Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for N-ary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> returnlist = new ArrayList<>();
        while (!queue.isEmpty()) {
            int nodesThisLevel = queue.size();
            List<Integer> thisLevel = new ArrayList<>();
            while (nodesThisLevel-- > 0) {
                Node node = queue.poll();
                if (node != null) {
                    thisLevel.add(node.val);
                    queue.addAll(node.children);
                }
            }
            returnlist.add(thisLevel);
        }
        return returnlist;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
