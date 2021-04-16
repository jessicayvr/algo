package problems.trees;

import model.TreeNode;

import java.util.Stack;

//O(H+K)
public class kthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            root = cur.right;
        }
        return -1;
    }
}
