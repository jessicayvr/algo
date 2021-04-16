package problems.linkedList;

import model.ListNode;

import java.util.*;

public class mergeKLists {

    public static void main(String[] args) {
        // 1->2->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // 1->3->4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode listNode = mergeKLists(lists);
        System.out.print(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        // add all nodes in pq
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.val));
        for (int i = 0 ; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                pq.add(list);
                list = list.next;
            }
        }
        ListNode cur = new ListNode(0);
        ListNode dum = cur;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            dum.next = poll;
            dum = dum.next;
        }

        return cur.next;
    }

}
