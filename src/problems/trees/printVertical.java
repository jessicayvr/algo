package problems.trees;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// O(N)
public class printVertical {
    public static void main(String[] args) {
        /**
         *            1
         *         /    \
         *        2      3
         *       / \   /   \
         *      4   5  6   7
         *                /  \
         *               8   9
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println(printVertical(root));
    }

    public static List<List<Integer>> printVertical(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        getVerticalOrder(root,0,map);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static void getVerticalOrder(TreeNode root, int d, TreeMap<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(d, new ArrayList<>());
        list.add(root.val);
        map.put(d, list);

        getVerticalOrder(root.left, d-1, map);
        getVerticalOrder(root.right, d+1, map);
    }
}