package problems.linkedList;

import model.ListNode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class reverse {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        reverse(root);
    }

    private static ListNode reverse(ListNode root) {
        ListNode cur = root;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
