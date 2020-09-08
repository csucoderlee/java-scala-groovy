package org.csu.coderlee.interview.greyireland;

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
        Node root = new Node();
        root.setValue(6);
        root.setLeft(new Node().setValue(5).setLeft(new Node().setValue(4)).setRight(new Node().setValue(3)));
        root.setRight(new Node().setValue(7).setLeft(new Node().setValue(8)).setRight(new Node().setValue(9)));

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
    private static void preOrderTraversal(Node root) {

        if (root == null) return;
        System.out.println(root.getValue());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    /**
     * 中序遍历，递归方式
     * @param root
     */
    private static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.getLeft());
        System.out.println(root.getValue());
        inOrderTraversal(root.getRight());
    }

    /**
     * 后序遍历，递归方式
     * @param root
     */
    private static void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root.getValue());
    }

    /**
     * 前序遍历，非递归方式
     */
    private static void preOrderTraversal1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();

        //放入根节点
        stack.push(root);

        while (!stack.empty()) {
            //取出根节点
            Node p = stack.pop();
            System.out.println(p.getValue());

            //放入右子树
            if (p.getRight() != null) {
                stack.push(p.getRight());
            }

            //放入左子树
            if (p.getLeft() != null) {
                stack.push(p.getLeft());
            }
        }
    }

    /**
     * 中序遍历，非递归方式
     * @param root
     */
    private static void inOrderTraversal1(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (temp != null || !stack.isEmpty()) {

            while (temp != null) {
                //当前节点的所有左孩子入栈
                stack.push(temp);
                temp = temp.getLeft();
            }

            //取出栈顶元素，即当前最左侧的子节点
            temp = stack.pop();
            System.out.println(temp.getValue());

            //栈顶元素存在右节点，则需要继续处理右节点的左节点，即进入重复
            if (temp.getRight() != null) {
                temp = temp.getRight();
            } else {
                temp = null;
            }
        }
    }

    /**
     * 后序遍历，非递归方式
     * @param root
     */
    private static void postOrderTraversal1(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node temp = root;
        Node pre = null;

        while (temp != null || !stack.isEmpty()) {

            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }


            if (!stack.isEmpty()) {
                temp = stack.peek();

                if (temp.getRight() == null || temp.getRight() == pre) {
                    temp = stack.pop();
                    System.out.println(temp.getValue());
                    pre = temp;
                    temp = null;
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    /**
     * 广度优先搜索
     * @param root
     */
    private static void bfsTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            System.out.println(poll.getValue());

            if (poll.getLeft() != null) {
                queue.add(poll.getLeft());
            }

            if (poll.getRight() != null) {
                queue.add(poll.getRight());
            }
        }

    }

    /**
     * 深度优先搜索
     * @param root
     */
    private static void dfsTraversal(Node root) {
        //略，即先序遍历
        //先从根节点出发,沿着左子树纵向遍历直至找到叶子节点，然后回溯到前一个节点，遍历右子树
        return;
    }
}