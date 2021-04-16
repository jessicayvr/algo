package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class populatingNextPointers {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node node = addPointers(root);
        System.out.print(node);
    }

    private static Node addPointers(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            // size here represents node per level
            for (int i = 0 ; i < size; i++) {
                Node poll = q.poll();

                // handle first Node and last Node
                if (i == size -1 || q.isEmpty()) {
                    poll.next = null;
                } else {
                    poll.next = q.peek();
                }


                // add left
                if (poll.left != null) {
                    q.add(poll.left);
                }

                // add right
                if (poll.right != null) {
                    q.add(poll.right);
                }

            }
        }

        return root;
    }
}
