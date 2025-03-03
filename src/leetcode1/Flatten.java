package leetcode1;

public class Flatten {

    // Solution using Morris traversal

    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node of left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect rightmost node to current right subtree
                pre.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to next node
            curr = curr.right;
        }
    }
}
