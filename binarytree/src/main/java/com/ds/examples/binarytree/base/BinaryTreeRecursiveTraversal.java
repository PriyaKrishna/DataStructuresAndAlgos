package com.ds.examples.binarytree.base;

/**
 * Created by D-YW44CN on 2/09/2016.
 */
public class BinaryTreeRecursiveTraversal {
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.getLeft());
        System.out.println(root.getData());
        inorder(root.getRight());
    }
}
