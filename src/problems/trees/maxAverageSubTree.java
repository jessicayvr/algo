package problems.trees;

import java.util.Arrays;
import java.util.List;

public class maxAverageSubTree {
    private static class TreeNode {
        private int val;
        private List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode left = new TreeNode(12);
        TreeNode right = new TreeNode(18);
        right.children = Arrays.asList(new TreeNode(15), new TreeNode(8));
        left.children = Arrays.asList(new TreeNode(11), new TreeNode(2), new TreeNode(3));
        root.children = Arrays.asList(left, right);

        int[] averageSub = findAverageSub(root);

        System.out.println(averageSub[0] + "  " + averageSub[1]);
        System.out.println(max);
        System.out.println(maxNode.val);

    }

    static double max = Integer.MIN_VALUE;
    static TreeNode maxNode;

    private static int[] findAverageSub(TreeNode root) {
        int countNode = 1;
        int sum = root.val;

        if (root.children != null) {
            for (TreeNode child : root.children) {
                int[] averageSub = findAverageSub(child);
                countNode = countNode + averageSub[0];
                sum = sum + averageSub[1];
            }
        }

        if (root.children != null && countNode > 1) {
            int rootsAverageSum = sum / countNode;
            if (rootsAverageSum > max) {
                max = rootsAverageSum;
                maxNode = root;
            }
        }

        return new int[]{countNode, sum};
    }

}
