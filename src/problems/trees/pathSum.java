package problems.trees;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

//O(n) or O(nodes + edges)
public class pathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
//                   5
//                  / \
//                 4   8
//                /   / \
//               11  13  4
//              /  \    / \
//            7    2  5   1
        System.out.println(pathSumI(root, 22));

        List<List<Integer>> result = new ArrayList<>();
        pathSumII(root, 22, result, new ArrayList<>());
        System.out.println(result);
    }

    private static boolean pathSumI(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right ==null) {
            return true;
        }
        return pathSumI(root.left, sum - root.val) || pathSumI(root.right, sum-root.val);
    }

    private static void pathSumII(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
        if (root ==null) {
            return;
        }
        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(temp));
        } else {

            pathSumII(root.right, sum-root.val, result, temp);
            pathSumII(root.left, sum-root.val, result, temp);
        }
        temp.remove(temp.size()-1);
    }
}
