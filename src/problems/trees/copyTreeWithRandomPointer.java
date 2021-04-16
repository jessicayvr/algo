package problems.trees;

import java.util.HashMap;
import java.util.Map;
// Time and Space O(n)
public class copyTreeWithRandomPointer {
    static class Node {
        int val;
        Node left;
        Node right;
        Node random;
        Node(int data)
        {
            this.val=data;
        }
    };
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.random = root.right.right;
        root.left.left.random = root;
        root.left.right.random = root.right.left.random;
        root.right.left.random = root.left;
        root.random = root.left.right;
        preorder(root);
        Node copy = copy(root);
        preorder(copy);
    }

    private static Node copy(Node root) {
        Map<Node, Node> map = new HashMap<>();
        traverseAndCreate(root, map);
        traverseAndClone(root, map);
        return map.get(root);
    }

    private static void traverseAndClone(Node root, Map<Node, Node> map) {
        if (root == null) {
            return;
        }
        traverseAndClone(root.left, map);
        Node clone = map.get(root);
        clone.left = map.get(root.left);
        clone.right = map.get(root.right);
        clone.random = map.get(root.random);
        traverseAndClone(root.right, map);
    }

    private static void traverseAndCreate(Node root, Map<Node, Node> map){
        if (root == null) {
            return;
        }
        traverseAndCreate(root.left, map);
        map.put(root, new Node(root.val));
        traverseAndCreate(root.right, map);
    }

    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
        preorder(root.left);
        System.out.print(root.val + " -> (");
        System.out.print((root.left != null ? root.left.val : "X") + ", ");
        System.out.print((root.right != null ? root.right.val : "X") + ", ");
        System.out.println((root.random != null ? root.random.val : "X") + ")");
        preorder(root.right);
    }
}
