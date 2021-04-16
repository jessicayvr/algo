package problems.trees;

import model.TreeNode;

public class diameterOfBinaryTree {
    public static void main(String[] args) {
        /**
         * longest path between any two nodes in a tree.
         *           1
         *          / \
         *         2   3
         *        / \
         *       4   5
         *
         *  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(3);

        int dia = diameterOfBinaryTree(root);
        System.out.print(dia);
    }

    private static int max = 0;

    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        // check diameter between left and right
        max = Math.max(left+right, max);

        // return max tree depth
        return Math.max(left, right) + 1;
    }
}
