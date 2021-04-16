package problems.linkedList;

import model.ListNode;

public class isPalindrome {

    /**
     * can also add all nodes into stack, traverse node while poppping.
     */
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(2);
        n.next.next.next.next = new ListNode(1);
        System.out.print(isPalindrome(n));
    }

    /**
     * find middle
     * reverse last half (if it's odd last half will be bigger
     * compare root and last half value
     */
    private static boolean isPalindrome(ListNode n) {
        // middle
        ListNode fast = n;
        ListNode slow = n;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode listNode = reverseLinkedList(slow);

        while (listNode != null) {
            if (listNode.val != n.val) {
                return false;
            }
            n = n.next;
            listNode = listNode.next;
        }
        return true;
    }

    private static ListNode reverseLinkedList(ListNode slow) {
        ListNode cur = slow;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
