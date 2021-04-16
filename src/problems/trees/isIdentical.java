package problems.trees;

import model.TreeNode;

public class isIdentical {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.right = new TreeNode(15);
        root1.left = new TreeNode(5);
        root1.left.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(15);
        root2.left = new TreeNode(5);
        root2.left.right = new TreeNode(2);

        System.out.print(doIdentical(root1, root2));
    }

    private static boolean doIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && doIdentical(root1.left, root2.left) && doIdentical(root1.right, root2.right);
    }
}
