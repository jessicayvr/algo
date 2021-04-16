package problems.trees;

import model.TreeNode;

public class boundryOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(3);
        boundaryTraversal(root);
    }

    private static void boundaryTraversal(TreeNode root) {
        printLeft(root);
        printLeaves(root);
        printRight(root.right);
    }

    private static void printLeaves(TreeNode root) {
        if (root == null)
            return;

        printLeaves(root.left);
        // Print it if it is a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.val);
        }
        printLeaves(root.right);
    }

    private static void printRight(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            printRight(root.right);
            System.out.print(root.val);
        } else if (root.left != null) {
            printRight(root.left);
            System.out.print(root.val);
        }
        // leaf do nothing;

    }

    private static void printLeft(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            System.out.print(root.val);
            printLeft(root.left);
        } else if (root.right != null) {
            System.out.print(root.val);
            printLeft(root.right);
        }

        // this means its a leaf don't do anything
    }
}
