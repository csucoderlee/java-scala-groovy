package org.csu.coderlee.interview.greyireland;

import org.csu.coderlee.interview.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历，前序、中序、后序
 * 注意两点：
 * 1. 前序中序后序，这个"序"指的就是根
 * 2. 左子树优先于右子树
 *
 * 比如说，
 * 前序遍历，这个"序"指的就是根。
 * 首先根要先遍历出来，
 * 然后是左子树（内部有子树，也是按照根+左子树+右子树木的套路来遍历），
 * 最后是右子树（内部有子树，也是按照根+左子树+右子树木的套路来遍历）。
 *
 */
public class TestBinaryTreeTraversal {

    public static void main(String[] args) {

        /**
         *               6
         *             /  \
         *            5    7
         *           / \  / \
         *          4  3 8  9
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        //前序遍历，输出 6 5 4 3 7 8 9
        preOrderTraversal(root);
        System.out.println("--------");

        //前序遍历
        preOrderTraversal1(root);
        System.out.println("--------");

        //中序遍历，输出 4 5 3 6 8 7 9
        inOrderTraversal(root);
        System.out.println("--------");

        //中序遍历，非递归
        inOrderTraversal1(root);
        System.out.println("--------");

        //后序遍历，输出 4 3 5 8 9 7 6
        postOrderTraversal(root);
        System.out.println("--------");

        //后序遍历，输出 4 3 5 8 9 7 6
        postOrderTraversal1(root);
        System.out.println("--------");

        //广度优先遍历 6 5 7 4 3 8 9
        bfsTraversal(root);
        System.out.println("--------");

    }


    /**
     * 前序遍历，递归方式
     * @param root
     */
    private static void preOrderTraversal(TreeNode root) {

        if (root == null) return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 中序遍历，递归方式
     * @param root
     */
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    /**
     * 后序遍历，递归方式
     * @param root
     */
    private static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    /**
     * 前序遍历，非递归方式
     */
    private static void preOrderTraversal1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //放入根节点
        stack.push(root);

        while (!stack.empty()) {
            //取出根节点
            TreeNode p = stack.pop();
            System.out.println(p.val);

            //放入右子树
            if (p.right != null) {
                stack.push(p.right);
            }

            //放入左子树
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    /**
     * 中序遍历，非递归方式
     * @param root
     */
    private static void inOrderTraversal1(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {

            while (temp != null) {
                //当前节点的所有左孩子入栈
                stack.push(temp);
                temp = temp.left;
            }

            //取出栈顶元素，即当前最左侧的子节点
            temp = stack.pop();
            System.out.println(temp.val);

            //栈顶元素存在右节点，则需要继续处理右节点的左节点，即进入重复
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
    }

    /**
     * 后序遍历，非递归方式
     * @param root
     */
    private static void postOrderTraversal1(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode pre = null;

        while (temp != null || !stack.isEmpty()) {

            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }


            if (!stack.isEmpty()) {
                temp = stack.peek();

                if (temp.right == null || temp.right == pre) {
                    temp = stack.pop();
                    System.out.println(temp.val);
                    pre = temp;
                    temp = null;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    /**
     * 广度优先搜索
     * @param root
     */
    private static void bfsTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();
            System.out.println(poll.val);

            if (poll.left != null) {
                queue.add(poll.left);
            }

            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

    }

    /**
     * 深度优先搜索
     * @param root
     */
    private static void dfsTraversal(TreeNode root) {
        //略，即先序遍历
        //先从根节点出发,沿着左子树纵向遍历直至找到叶子节点，然后回溯到前一个节点，遍历右子树
        return;
    }
}