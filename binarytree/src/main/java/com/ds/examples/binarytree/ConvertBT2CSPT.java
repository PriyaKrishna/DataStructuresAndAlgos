package com.ds.examples.binarytree;

import com.ds.examples.binarytree.com.ds.examples.binarytree.common.BinaryTreeRecursiveTraversal;

/**
 * Created by D-YW44CN on 2/09/2016.
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 */
public class ConvertBT2CSPT {
    public Node convert(Node root) {
        if (root == null) return null;
        Node left = convert(root.getLeft());
        Node right = convert(root.getRight());
        if (left == null && right == null) {
            return root;
        } rippleDownLeftAndBalance(root);
        return root;
    }

    private void rippleDownLeftAndBalance(Node root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return;
        } else if (root.getLeft() == null) {
            if (root.getRight().getData() < root.getData()) {
                root.getRight().setData(root.getRight().getData() + (root.getData() - root.getRight().getData()));
                rippleDownLeftAndBalance(root.getRight());
            } else if (root.getRight().getData() > root.getData()){
                root.setData(root.getData() + (root.getRight().getData() - root.getData()));
            }
        } else if (root.getRight() == null) {
            if (root.getLeft().getData() < root.getData()) {
                root.getLeft().setData(root.getLeft().getData() + (root.getData() - root.getLeft().getData()));
                rippleDownLeftAndBalance(root.getLeft());
            } else if (root.getLeft().getData() > root.getData()) {
                root.setData(root.getData() + (root.getLeft().getData() - root.getData()));
            }
        } else if (root.getData() < (root.getLeft().getData() + root.getRight().getData())){
            int diff = (root.getLeft().getData() + root.getRight().getData()) - root.getData();
            root.setData(root.getData() + diff);
        } else if (root.getData() > (root.getLeft().getData() + root.getRight().getData())){
            int diff = root.getData() - (root.getLeft().getData() + root.getRight().getData());
            root.getLeft().setData(root.getLeft().getData() + diff);
            rippleDownLeftAndBalance(root.getLeft());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        Node node1 = new Node(7);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(5);
        Node node5 = new Node(1);
        Node node6 = new Node(30);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        ConvertBT2CSPT instance = new ConvertBT2CSPT();
        instance.convert(root);
        BinaryTreeRecursiveTraversal.inorder(root);
    }
}
