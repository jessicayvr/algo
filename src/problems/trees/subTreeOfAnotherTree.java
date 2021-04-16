package problems.trees;

import model.TreeNode;

public class subTreeOfAnotherTree {
    public static void main(String[] args) {
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        TreeNode root1 = new TreeNode(26);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        root1.left = new TreeNode(10);
        root1.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(30);
        root1.left.right = new TreeNode(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(6);
        root2.left = new TreeNode(4);
        root2.left.right = new TreeNode(30);

        boolean subtree = isSubtree(root1, root2);
        System.out.println(subtree);
    }

    /**
     * A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
     */
    public static boolean isSubtree(TreeNode tree, TreeNode subTree) {
        if (subTree == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }

        if (isIdentical(tree, subTree)) {
            return true;
        }
        return isSubtree(tree.right, subTree) || isSubtree(tree.left, subTree);
    }

    private static boolean isIdentical(TreeNode tree, TreeNode subTree) {
        if (tree == null && subTree == null) {
            return true;
        }

        if (tree == null || subTree == null)
            return false;

        return (tree.val == subTree.val && isIdentical(tree.left, subTree.left) && isIdentical(tree.right, subTree.right));
    }

}
