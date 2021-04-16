package problems.linkedList;

import model.ListNode;

public class rotateList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode listNode = rotateRight(root, 2);
        System.out.print(listNode);

       // 3->4->5->1->2->null
    }

    /**
     * To rotate we only care about node number k and end node
     */
    private static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode cur = head;

        // get cur to point to node at k
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        // this will be end node
        ListNode first = cur;

        // find end of list
        while (cur.next != null) {
            cur = cur.next;
        }

        // connect end of the list to the head
        // now we have a cycle
        cur.next = head;

        // save so we can return later;
        ListNode root = first.next;

        //severe (this is end node)
        first.next = null;

        return root;
    }
}
