package problems.trees;

import model.TreeNode;

public class splitBST {
    //divide and conquer
    public static void main(String[] args) {
        /**
         *           4
         *         /   \
         *       2      6
         *      / \    / \
         *     1   3  5   7
         */

        //split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value
        //while the other subtree has all nodes that are greater than the target value.
        // It's not necessarily the case that the tree contains a node with value V.
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        int v = 2;
        TreeNode[] split = split(root, v);
        System.out.println(split);
    }

    private static TreeNode[] split(TreeNode root, int v) {
        // the side we are not working on is second
        TreeNode[] res = new TreeNode[]{null, null};
        if (root == null) {
            return res;
        }

        if (root.val <= v) {
            res = split(root.right, v);
            root.right = res[1];
            res[1] = root;
        } else {
            res = split(root.left, v);
            root.left = res[0];
            res[0] = root;
        }
        return res;
    }
}
