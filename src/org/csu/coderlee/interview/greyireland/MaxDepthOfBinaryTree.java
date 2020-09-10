package org.csu.coderlee.interview.greyireland;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解决二叉树的相关问题， 就从两种方式入手，广度优先遍历和深度优先遍历。
 * 无论是哪种方式，都是要遍历整棵树，时间复杂度即为O(N)
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    private static int maxDepthByDfs(Node root) {
        if (root == null) return 0;
        int depthOfLeft = maxDepthByDfs(root.getLeft());
        int depthOfRight = maxDepthByDfs(root.getRight());
        return Math.max(depthOfLeft, depthOfRight) + 1;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    private static int maxDepthByBfs(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node poll = queue.poll();

                if (poll.getLeft() != null) {
                    queue.add(poll.getLeft());
                }

                if (poll.getRight() != null) {
                    queue.add(poll.getRight());
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
