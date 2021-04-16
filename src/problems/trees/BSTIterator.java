package problems.trees;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inOrder(root, q);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return q.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    private void inOrder(TreeNode root, Queue<Integer> q) {
        if (root == null) {
            return;
        }

        inOrder(root.left, q);
        q.add(root.val);
        inOrder(root.right, q);
    }
}
