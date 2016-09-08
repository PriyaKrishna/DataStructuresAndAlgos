package com.ds.examples.binarytree.base;

/**
 * Created by D-YW44CN on 6/09/2016.
 */
public class BinaryTreeUtility {
    public static int height(Node root) {
        if (root == null) return 0;
        int lHeight = height(root.getLeft());
        int rHeight = height(root.getRight());
        return Math.max(lHeight, rHeight) + 1;
    }

    public static class Height {
        int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
