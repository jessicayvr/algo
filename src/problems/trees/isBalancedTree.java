package problems.trees;

import model.TreeNode;

public class isBalancedTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.right = new TreeNode(15);
        root1.left = new TreeNode(5);
        root1.left.right = new TreeNode(53);
        root1.left.right.right = new TreeNode(7);
        System.out.print(isBalanced(root1));
    }

    private static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight -rightHeight) > 1) {
            return false;
        } else {
            // do this for the sub trees on 2 and 3
            /*
             *           1
             *          / \
             *         2   3
             *        / \   \
             *       4   5   7
             *      6         8
             *     7
             */
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    private static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
