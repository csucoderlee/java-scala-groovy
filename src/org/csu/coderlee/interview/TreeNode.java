package org.csu.coderlee.interview;

public class TreeNode {

    private int value;
    private TreeNode left;
    private TreeNode right;

    public int getValue() {
        return value;
    }

    public TreeNode setValue(int value) {
        this.value = value;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }
}
