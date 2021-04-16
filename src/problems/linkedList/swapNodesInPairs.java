package problems.linkedList;

import model.ListNode;

public class swapNodesInPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(l1);
        System.out.print(listNode);
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        ListNode l1 = head;
        ListNode l2;

        while(l1 != null && l1.next != null) {
            // l2 = 2
            l2 = l1.next;

            // 1->3
            l1.next = l2.next;

            // 2->1
            l2.next = l1;

            // root-> 2
            prev.next = l2; // reset prev ptr

            // prev = 1
            prev = l1;

            // l1 = 3
            l1 = l1.next;
        }
        return root.next;
    }
}
