package org.josh.singh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 */
public class MaximumDepthOfNaryTree_559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        List<Node> childrenThisLevel = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            childrenThisLevel.addAll(n.children);

            if (queue.isEmpty()) {
                level++;
                queue.addAll(childrenThisLevel);
                childrenThisLevel.clear();
            }
        }
        return level;
    }


}
