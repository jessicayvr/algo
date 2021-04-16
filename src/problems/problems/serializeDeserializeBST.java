package problems.problems;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class serializeDeserializeBST {

    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        String serialize = c.serialize(root);
        System.out.print(serialize);
        c.deserialize(serialize);

    }

    public static class Codec {

        public Codec() {

        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        // print post order
        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(Queue<String> q, int lower, int upper) {
            if (q.isEmpty()) return null;
            String s = q.peek();
            int val = Integer.parseInt(s);

            // this is not a BST anymore switch sides
            if (val < lower || val > upper){
                return null;
            }
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }
    }

}
