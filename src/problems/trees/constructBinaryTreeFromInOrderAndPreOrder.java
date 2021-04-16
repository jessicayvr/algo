package problems.trees;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class constructBinaryTreeFromInOrderAndPreOrder {

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        TreeNode bt = constructBT(preorder, inorder);
        /**
         *   1
         *  23
         * 4567
         */

        System.out.println(bt);
    }

    private static TreeNode constructBT(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    private static TreeNode construct(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIdx = map.get(root.val);

        root.left = construct(preStart + 1, inStart, rootIdx - 1, preorder, inorder, map);
        root.right = construct(preStart + 1 + rootIdx - inStart, rootIdx + 1, inEnd, preorder, inorder, map);

        return root;
    }
}
