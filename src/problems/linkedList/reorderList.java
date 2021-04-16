package problems.linkedList;

import model.ListNode;

public class reorderList {

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        reorder(n);
        System.out.print("done");
    }

    private static ListNode reorder(ListNode n) {
        ListNode first = n;
        ListNode second = n;

        //find middle
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
        }

        ListNode reverse = reverse(second.next);
        // this is to stop the temp list
        second.next = null;
        ListNode temp = n;

        // 123 | 4
        // 123 | 54

        while(temp != null && reverse != null){
            ListNode revNext = reverse.next;
            ListNode tempNext = temp.next;
            temp.next = reverse;
            reverse.next = tempNext;
            reverse = revNext;
            temp = tempNext;
        }

        return n;
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
