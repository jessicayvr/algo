package problems.trees;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
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

        List<List<Integer>> lists = doLeverOrder(root);
        System.out.print(lists);
    }

    private static List<List<Integer>> doLeverOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                levelList.add(poll.val);

                if (poll.left != null) {
                    q.add(poll.left);
                }

                if (poll.right != null) {
                    q.add(poll.right);
                }
            }

            result.add(levelList);


        }
        return result;
    }
}
