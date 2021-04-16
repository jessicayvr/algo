package problems.trees;

import model.TreeNode;
//O(n)
public class lowestAncestorTree {

    public static void main(String[] args) {
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode treeNode = lcaTree(root, root.right.left, root.right.right);
        System.out.print(treeNode.val);
    }

    // once we hit root, we should know the answer.
    private static TreeNode lcaTree(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return null;
        }
        if (root == left || root == right) {
            return root;
        }

        TreeNode leftAns = lcaTree(root.left, left, right);
        TreeNode rightAns = lcaTree(root.right, left, right);

        if (leftAns != null && rightAns != null) {
            return root;
        } else {
            // right could be null
          return left == null ? right : left;
        }
    }
}
