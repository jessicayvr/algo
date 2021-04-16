package problems.trees;

import model.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class deserializeSerializeBT {

    public static void main(String[] args) {
        /**
         *         1
         *        / \
         *       2  3
         *     /  \
         *    4   5
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BT b = new BT();
        String str = b.serialize(root);
        TreeNode deserialize = b.deserialize(str);
        System.out.println(deserialize);
    }

    //preOrder
    public static class BT {
        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
           StringBuilder sb = new StringBuilder();
           buildString(root, sb);
           return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
           if (node == null) {
               sb.append("X").append(spliter);
           } else {
               sb.append(node.val).append(spliter);
               buildString(node.left, sb);
               buildString(node.right, sb);
           }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(spliter);
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(split));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String remove = nodes.remove();
            if(remove.equals("X")) {
                return null;
            } else {
                TreeNode n = new TreeNode(Integer.valueOf(remove));
                n.left = buildTree(nodes);
                n.right = buildTree(nodes);
                return n;
            }
        }
    }
}
