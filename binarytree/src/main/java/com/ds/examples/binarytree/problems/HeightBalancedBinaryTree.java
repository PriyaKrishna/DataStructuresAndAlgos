package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.BinaryTreeUtility;
import com.ds.examples.binarytree.base.Node;

/**
 How to determine if a binary tree is height-balanced?
 An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 1) Left subtree of T is balanced
 2) Right subtree of T is balanced
 3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class HeightBalancedBinaryTree {
    public boolean isTreeHeightBalanced(Node root, BinaryTreeUtility.Height h) {

        if (root == null){
            h.setVal(0);
            return true;
        }
        int lHeight = 0;
        int rHeight = 0;

        boolean lBalanced = isTreeHeightBalanced(root.getLeft(), h);
        lHeight = h.getVal();
        boolean rBalanced = isTreeHeightBalanced(root.getRight(), h);
        rHeight = h.getVal();
        h.setVal(Math.max(lHeight, rHeight) + 1);

        if (lBalanced && rBalanced &&
                (Math.abs(lHeight - rHeight) == 1 || lHeight - rHeight == 0)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        //node2.setLeft(node5);

        node3.setLeft(node6);

        HeightBalancedBinaryTree instance = new HeightBalancedBinaryTree();
        BinaryTreeUtility.Height h = new BinaryTreeUtility.Height();
        h.setVal(0);
        System.out.println(instance.isTreeHeightBalanced(root, h));

    }
}
