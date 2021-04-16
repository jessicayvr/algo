package problems.trees;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// left root right
// O(n)
public class inorderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        List<Integer> result = new ArrayList<>();
        inOrderRecur(tree, result);
        System.out.print(result);
        inOrderIteration(tree);
    }

    private static void inOrderRecur(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left, result);
        result.add(node.val);
        inOrderRecur(node.right, result);
    }

    private static void inOrderIteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            node = pop.right;
        }
    }


}
