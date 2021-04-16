package problems.linkedList;

/**
 * O(l1+l2)
 */
public class mergeTwoSortedArrays {

    //Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
       // 1->2->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // 1->3->4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.print(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;

        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1_cur != null && l2_cur != null) {
            if (l1_cur.val <= l2_cur.val) {
                cur.next = l1_cur;
                cur = cur.next;
                l1_cur = l1_cur.next;
            } else {
                cur.next = l2_cur;
                cur = cur.next;
                l2_cur = l2_cur.next;
            }
        }


        if (l1_cur != null) {
            cur.next = l1_cur;
        }
        if (l2_cur != null) {
            cur.next = l2_cur;
        }

        return result.next;

    }
}
