package problems.trees;

import model.TreeNode;

public class convertBStToGreaterTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode treeNode = convertBST(root);
        System.out.print("done");
    }
    static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum = root.val + sum;
            root.val = sum;
            convertBST(root.left);
        }
      return root;
    }

}
