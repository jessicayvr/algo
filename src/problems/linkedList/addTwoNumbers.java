package problems.linkedList;

// O(V+E) simply DFS with an extra stack
public class addTwoNumbers {

    private static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
         val = x;
     }
  }

 public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//     ListNode listNode = new ListNode(8);
//     l1.next = listNode;
//     listNode.next = new ListNode(9);

     ListNode l2 = new ListNode(9);
     ListNode listNode2 = new ListNode(9);
     l2.next = listNode2;
//     listNode2.next = new ListNode(9);

     ListNode listNode1 = addTwoNumbers(l1, l2);

     System.out.print("ho");


 }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;

        ListNode x = l1;
        ListNode y = l2;
        int carry=0;
        while (x != null && y != null) {
            int sum = x.val + y.val + carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            cur.next = listNode;
            cur = cur.next;
            x = x.next;
            y = y.next;
        }

        while (x != null) {
            int sum = x.val + carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            cur.next = listNode;
            cur = cur.next;
            x = x.next;
        }
        while (y != null) {
            int sum = y.val + carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            cur.next = listNode;
            cur = cur.next;
            y = y.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return node.next;

    }

}
