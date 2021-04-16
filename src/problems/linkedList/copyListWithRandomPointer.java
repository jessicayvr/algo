package problems.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity : O(n)
 * Auxiliary space : O(n)
 */
public class copyListWithRandomPointer {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        deepCopy(start);
    }

    private static Node deepCopy(Node start) {
        Node curr_start = start;

        // original, clone
        Map<Node, Node> map = new HashMap<>();

        // Traverse the original list and make a copy of that
        // in the clone linked list.
        while (curr_start != null) {
            Node node = new Node(curr_start.val);
            map.put(curr_start, node);
            curr_start = curr_start.next;
        }
        curr_start = start;

        // Traversal of original list again to adjust the next
        // and random references of clone list using hash map.
        while (curr_start != null) {
            Node clone = map.get(curr_start);
            clone.next = map.get(curr_start.next);
            clone.random = map.get(curr_start.random);
            curr_start = curr_start.next;
        }

        return map.get(start);

    }
}
