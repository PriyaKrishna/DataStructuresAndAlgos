package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.BinaryTreeRecursiveTraversal;
import com.ds.examples.binarytree.base.BinaryTreeUtility;
import com.ds.examples.binarytree.base.Node;

/**
 * Created by D-YW44CN on 8/09/2016.
 */
public class ConstructBinaryTreeFromInorderPreorder {
    private static int preorderIndex = 0;
    public Node buildTree(int[] inorder, int[] preorder, int low, int high) {
        if (low > high) return null;
        int data = preorder[preorderIndex++];
        Node root = new Node(data);

        if (low == high) {
            return root;
        }
        int inorderIndex = searchIndex(inorder, data, low, high);
        root.setLeft(buildTree(inorder, preorder, low, inorderIndex -1));
        root.setRight(buildTree(inorder, preorder, inorderIndex + 1, high));
        return root;
    }

    private int searchIndex(int[] inorder, int data, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (data == inorder[mid]) {
            return mid;
        }
        else if (data > inorder[mid]) {
            return searchIndex(inorder, data, mid + 1, high);
        } else {
            return searchIndex(inorder, data, low, mid -1);
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

        int[] inorder = new int[]{3, 7, 5, 50, 1, 2, 30};
        int[] preorder = new int[]{50, 7, 3, 5, 2, 1, 30};
        ConstructBinaryTreeFromInorderPreorder instance = new ConstructBinaryTreeFromInorderPreorder();
        Node builtRoot = instance.buildTree(inorder, preorder, 0, 6);
        BinaryTreeRecursiveTraversal.inorder(builtRoot);
    }
}
