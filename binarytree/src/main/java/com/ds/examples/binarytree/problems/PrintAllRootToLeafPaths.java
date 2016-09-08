package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.Node;

/**
 * Created by D-YW44CN on 8/09/2016.
 */
public class PrintAllRootToLeafPaths {

    public void printAllRootToLeafPaths(Node root, int[] arr, int pointer) {
        if (root == null) {
            return;
        } else {
            arr[pointer++] = root.getData();
            if (root.getLeft() == null && root.getRight() == null) {
                print(arr, pointer);
            }
            if (root.getLeft() != null) {
                printAllRootToLeafPaths(root.getLeft(), arr, pointer);
            }
            if (root.getRight() != null) {
                printAllRootToLeafPaths(root.getRight(), arr, pointer);
            }
        }
    }

    private void print(int[] arr, int pointer) {
        for (int i = 0; i < pointer; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
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

        PrintAllRootToLeafPaths instance = new PrintAllRootToLeafPaths();
        int[] arr = new int[Integer.MAX_VALUE/4];
        instance.printAllRootToLeafPaths(root, arr, 0);

    }
}
