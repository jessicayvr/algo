package problems.linkedList;

import model.ListNode;

public class intersectionOfTwoLinkedList {
    public static void main(String[] args) {
        getIntersectionNode(null, null);
    }

    // get length of A and B
    // find diff between A,B. Longer node to diff. Then iterate together
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getCount(headA);
        int b = getCount(headB);

        if (a > b) {
            return getIntersection(a - b, headA, headB);
        } else {
            return getIntersection(b - a, headB, headA);
        }
    }

    public static ListNode getIntersection(int dif, ListNode a, ListNode b) {
        ListNode cur = a;
        for (int i = 0; i < dif; i++) {
            cur = cur.next;
        }

        while (cur != null && b != null) {
            if (cur == b) {
                return cur;
            }
            cur = cur.next;
            b = b.next;
        }
        return null;
    }

    public static int getCount(ListNode n) {
        int count = 0;

        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }
}
