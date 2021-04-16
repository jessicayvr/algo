package problems.trees;

import model.TreeNode;

public class isMirror {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.right = new TreeNode(7);
        root1.left = new TreeNode(15);
        root1.left.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(15);
        root2.left = new TreeNode(7);
        root2.right.left = new TreeNode(1);

        System.out.print(doMirror(root1, root2));
    }

    private static boolean doMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && doMirror(root1.right, root2.left) && doMirror(root1.left, root2.right);
    }
}
