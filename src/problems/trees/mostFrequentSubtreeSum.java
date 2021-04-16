package problems.trees;

import model.TreeNode;

import java.util.*;

public class mostFrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        int[] frequentTreeSum = findFrequentTreeSum(root);
        System.out.print(frequentTreeSum);
    }

    private static int[] findFrequentTreeSum(TreeNode root) {
       Map<Integer, Integer> map = new HashMap<>();
       helper(root, map);

       int max = 0;
       List<Integer> result = new ArrayList<>();
       for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
           if (entry.getValue() > max) {
               max = entry.getValue();
               result.clear();
               result.add(entry.getKey());
           } else if (entry.getValue() == max) {
               result.add(entry.getKey());
           }
       }
       return result.stream().mapToInt(i->i).toArray();
    }

    private static TreeNode helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return null;
        }
        int sum = root.val;
        if (root.left != null) {
            sum = sum + helper(root.left, map).val;
        }
        if (root.right != null) {
            sum = sum + helper(root.right, map).val;
        }

        root.val = sum;
        Integer count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        return root;
    }
}
