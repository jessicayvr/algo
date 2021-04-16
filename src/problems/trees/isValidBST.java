package problems.trees;

import model.TreeNode;

public class isValidBST {

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(15);
        root2.left = new TreeNode(5);
        root2.left.right = new TreeNode(7);

        System.out.print(isValid(root2));
    }

    private static boolean isValid(TreeNode root) {
        return doValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean doValid(TreeNode root, int maxValue, int minValue) {
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }
        return doValid(root.left, root.val - 1, minValue) && doValid(root.right, maxValue, root.val + 1);
    }

}
