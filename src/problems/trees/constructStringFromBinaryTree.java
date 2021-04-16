package problems.trees;

import model.TreeNode;

/**
 * Time complexity : O(n) The preorder traversal is done over the nn nodes of the given Binary Tree.
 *
 * Space complexity : O(n). The depth of the recursion tree can go upto nn in case of a skewed tree.
 */
public class constructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        String convert = convert(root);
        System.out.print(convert);
    }

    private static String convert(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = convert(root.left);
        String right = convert(root.right);


        if (left == "" && right == "") {
            return String.valueOf(root.val);
        } else if (right == "") {
            return root.val + "(" + left + ")";
        } else {
            return root.val + "(" + left + ")" + "(" + right + ")";
        }

    }
}
