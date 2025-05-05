package leetcode1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
    }
    private HashMap<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        // Store inorder values and their indices for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
TreeMap<Integer, Integer> map=new TreeMap<>();
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int left, int right) {
        // Base case: if no elements to construct the tree
        if (left > right) return null;

        // Select the current preorderIndex as the root value

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of this root in inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively build left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }

}
