package problems.linkedList;

import model.ListNode;

/**
 * Time Complexity: O(N+k) nodes in the given list.
 * If kk is large, it could still require creating many new empty lists.
 *
 * Space Complexity: O(max(N,k)), the space used in writing the answer.
 */
public class splitIntoEvenParts {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        n.next.next.next.next.next.next = new ListNode(7);
        ListNode[] listNodes = splitListToParts(n, 10);
        System.out.print(listNodes);
    }

    private static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int width = count / k;
        int rem = count % k;

        cur = root;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode temp = new ListNode(0);
            ListNode write = temp;
            // for loop will also avoid null pointer because 0 < 0
            for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                write.next = new ListNode(cur.val);
                cur = cur.next;
                write = write.next;
            }
            result[i] = temp.next;
        }
        return result;
    }
}
