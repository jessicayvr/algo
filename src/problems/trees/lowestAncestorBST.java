package problems.trees;

import model.TreeNode;

public class lowestAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        TreeNode treeNode = lcaBst(root, root, root.right);
        System.out.print(treeNode.val);
    }

    private static TreeNode lcaBst(TreeNode root, TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return null;
        }

        if (left.val < root.val && right.val < root.val) {
           return lcaBst(root.left, left, right);
        }
        if (left.val > root.val && right.val > root.val) {
            return lcaBst(root.right, left, right);
        }

        return root;
    }
}
