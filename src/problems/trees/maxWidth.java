package problems.trees;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(3);
        root.right= new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(9);
        int i = widthOfBinaryTree(root);
        System.out.print(i);
    }
    private static int widthOfBinaryTree(TreeNode root) {
     Queue<TreeNode> q = new LinkedList<>();
     root.val = 0;
     q.add(root);
     int left = 0;
     int right = 0;
     int max = 0;

     // for each level find the left idx and right idx
     // calculate index for each left and right
     // index is the position of the node start at 0 for most left
        // left = i*2
        // right  = i*2 + 1
     while (!q.isEmpty()) {
         int size = q.size();
         for (int i = 0; i < size; i++) {
             TreeNode poll = q.poll();

             // has to be left;
             if (i == 0) {
                 left = poll.val;
             }
             // has to be right;
             if (i == size-1) {
                 right = poll.val;
             }

             if (poll.left != null) {
                 poll.left.val = 2* poll.val;
                 q.add(poll.left);
             }

             if (poll.right != null) {
                 poll.right.val = 2* poll.val + 1;
                 q.add(poll.right);
             }
         }
         max = Math.max(right - left + 1, max);
     }
     return max;
    }
}
