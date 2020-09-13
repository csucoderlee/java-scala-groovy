package org.csu.coderlee.interview.greyireland;

import org.csu.coderlee.interview.TreeNode;

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
    private static int maxDepthByDfs(TreeNode root) {
        if (root == null) return 0;
        int depthOfLeft = maxDepthByDfs(root.left);
        int depthOfRight = maxDepthByDfs(root.right);
        return Math.max(depthOfLeft, depthOfRight) + 1;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    private static int maxDepthByBfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
