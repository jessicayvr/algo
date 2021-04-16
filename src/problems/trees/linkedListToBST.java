package problems.trees;

import model.ListNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time O(N) since we used array, accessing takes O(1)
 * Space = O(N) for array.
 */
public class linkedListToBST {
    public static void main(String[] args) {
        //   [-10,-3,0,5,9]
        ListNode root = new ListNode(-10);
        root.next = new ListNode(-3);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(9);

        TreeNode treeNode = convertListToTree(root);
        System.out.print(treeNode);
    }

    private static TreeNode convertListToTree(ListNode root) {
        List<Integer> nums = new ArrayList<>();
        while (root != null) {
            nums.add(root.val);
            root = root.next;
        }

        return convertListToBST(nums, 0, nums.size()-1);
    }

    private static TreeNode convertListToBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end ) /2;
        TreeNode root = new TreeNode(nums.get(mid));

        root.left = convertListToBST(nums, start, mid-1);
        root.right = convertListToBST(nums, mid+1, end);

        return root;
    }
}
