package leetcode1;

import java.util.concurrent.atomic.AtomicInteger;

public class BSTToGst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode bstToGst(TreeNode root) {
        AtomicInteger sum = new AtomicInteger(0);
        reverseInOrderHelper(root, sum);
        return root;
    }

    private static void reverseInOrderHelper(TreeNode node, AtomicInteger  sum) {
        if (node == null) {
            return;
        }

        reverseInOrderHelper(node.right, sum);

        sum.addAndGet(node.val);
        node.val = sum.get();

        reverseInOrderHelper(node.left, sum);
    }
}
