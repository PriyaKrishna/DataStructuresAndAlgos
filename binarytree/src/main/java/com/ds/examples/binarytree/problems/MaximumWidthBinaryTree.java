package com.ds.examples.binarytree.problems;

import com.ds.examples.binarytree.base.BinaryTreeUtility;
import com.ds.examples.binarytree.base.Node;

/**
 * Created by D-YW44CN on 8/09/2016.
 */
public class MaximumWidthBinaryTree {
    public int maximumWidth(Node root) {
        int height = BinaryTreeUtility.height(root);
        int max = 0;
        for (int i = 1; i <= height; i++) {
            max = Math.max(max, getCountAtlevel(root, i, 0));
        }
        return max;
    }

    private int getCountAtlevel(Node root, int i, int count) {
        if (i == 1) return ++count ;
        if (i > 1) {
            return (getCountAtlevel(root.getLeft(), i-1, count) + getCountAtlevel(root.getRight(), i - 1, count));
        }
    }
}
