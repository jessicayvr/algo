package problems.linkedList;

import model.ListNode;

public class palindromeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(2);

        boolean b = doPalindrome(l1);
        System.out.print(b);
    }
    // find middle
    // reverse second half of linked list
    // compare first and second half
    private static boolean doPalindrome(ListNode root) {
        ListNode fast = root;
        ListNode slow = root;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow is now the middle
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        ListNode cur = root;

        // cur is longer by 1 if odd
        while (reversed != null && cur != null) {
            if (reversed.val != cur.val) {
                return false;
            }
            reversed = reversed.next;
            cur = cur.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode root) {
        ListNode cur = root;
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
