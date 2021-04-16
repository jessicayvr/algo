package problems.linkedList;

import model.ListNode;

// O(nlogn)
// divide the list in two, keep dividing until there are one element on each side
// re construct left and right with merge
public class sortList {

    public static void main(String[] args) {
        ListNode n = new ListNode(3);
        n.next = new ListNode(5);
        n.next.next = new ListNode(2);
        n.next.next.next = new ListNode(1);
        n.next.next.next.next = new ListNode(4);
        ListNode listNode = mergeSort(n);
        System.out.print(listNode);
    }

    private static ListNode mergeSort(ListNode n) {

        if (n == null || n.next == null) {
            return n;
        }

        // end of the 2nd list
        ListNode fast = n;

        // start of the 2nd list
        ListNode slow = n;

        // end of the 1st list
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }

        // cut the list in half
        prev.next = null;
        ListNode left = mergeSort(n);
        ListNode right = mergeSort(slow);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode n1 = left;
        ListNode n2 = right;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                cur.next = n2;
                n2 = n2.next;
            } else {
                cur.next = n1;
                n1 = n1.next;
            }
            cur = cur.next;
        }

        if (n1 != null) {
            cur.next = n1;
        }

        if (n2 != null) {
            cur.next = n2;
        }
        return head.next;
    }
}
