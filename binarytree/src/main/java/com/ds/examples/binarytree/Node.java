package com.ds.examples.binarytree;

/**
 * Created by D-YW44CN on 2/09/2016.
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int val) {
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
