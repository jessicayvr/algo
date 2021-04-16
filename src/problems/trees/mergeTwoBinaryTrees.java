package problems.trees;

import model.TreeNode;

/**
 *  O(m). A total of m nodes need to be traversed.
 *  Here, m represents the minimum number of nodes from the two given trees.
 *
 * Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree.
 * In average case, depth will be O(logm) (height of the tree)
 */
public class mergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        mergeBinaryTrees(root, root2);
    }

    private static TreeNode mergeBinaryTrees(TreeNode n1, TreeNode n2) {

        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        n1.val = n1.val + n2.val;

        n1.left = mergeBinaryTrees(n1.left, n2.left);
        n1.right = mergeBinaryTrees(n1.right, n2.right);


        return n1;
    }

}
