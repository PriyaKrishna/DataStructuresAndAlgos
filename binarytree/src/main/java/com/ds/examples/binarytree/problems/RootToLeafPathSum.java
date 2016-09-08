package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.Node;

/**
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals the given number. Return false if no such path can be found.
 */
public class RootToLeafPathSum {
    public boolean sumExists(Node root, Count ct, int sum) {
        if (root == null) {
            if (ct.getVal() == sum) return true;
            return false;
        }
        Count lcount = new Count();
        lcount.setVal(ct.getVal());
        lcount.setVal(lcount.getVal() + root.getData());
        Count rcount = new Count();
        rcount.setVal(ct.getVal());
        rcount.setVal(rcount.getVal() + root.getData());
        if (sumExists(root.getLeft(), lcount, sum) || (sumExists(root.getRight(), rcount, sum))) {
            return true;
        }
        return false;
    }

    public boolean sumExistsBetterApproach(Node root, int sum) {
        if (root == null) {
            System.out.println("Sum is " + sum);
            if (sum == 0) return true;
            return false;
        }
        sum = sum - root.getData();

        if (sumExistsBetterApproach(root.getLeft(),sum) || (sumExistsBetterApproach(root.getRight(), sum))) {
            return true;
        }
        return false;
    }

    private class Count {
        int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(5);
        Node node5 = new Node(2);

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node5);
        node1.setLeft(node3);
        node1.setRight(node4);
        RootToLeafPathSum instance = new RootToLeafPathSum();
        Count ct = instance.new Count();
        ct.setVal(0);
        System.out.println("Sum exists " + instance.sumExists(root, ct, 23 ));
        System.out.println("Sum exists " + instance.sumExists(root, ct, 21 ));
        System.out.println("Sum exists " + instance.sumExists(root, ct, 14 ));
        System.out.println("Sum exists " + instance.sumExists(root, ct, 10 ));
        System.out.println("Sum exists " + instance.sumExists(root, ct, 8 ));

        System.out.println("Sum exists BetterApproach " + instance.sumExistsBetterApproach(root,  23 ));
        System.out.println("Sum exists BetterApproach " + instance.sumExistsBetterApproach(root,  21 ));
        System.out.println("Sum exists BetterApproach " + instance.sumExistsBetterApproach(root,  14 ));
        System.out.println("Sum exists BetterApproach " + instance.sumExistsBetterApproach(root,  10 ));
        System.out.println("Sum exists BetterApproach " + instance.sumExistsBetterApproach(root,  8 ));
    }
}
