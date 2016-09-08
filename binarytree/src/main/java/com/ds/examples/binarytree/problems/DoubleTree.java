package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.BinaryTreeRecursiveTraversal;
import com.ds.examples.binarytree.base.Node;

/**
 * Created by D-YW44CN on 8/09/2016.
 */
public class DoubleTree {
    public void doubleTree(Node root) {
        if (root == null) return;
        Node duplicate = new Node(root.getData());
        Node temp = root.getLeft();
        root.setLeft(duplicate);
        duplicate.setLeft(temp);
        doubleTree(duplicate.getLeft());
        doubleTree(root.getRight());
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

        DoubleTree instance = new DoubleTree();
        instance.doubleTree(root);
        BinaryTreeRecursiveTraversal.inorder(root);
    }
}
