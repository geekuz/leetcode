package leetcode1;

public class BT_117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return null;

        Node currentLevel = root; // Pointer to track the current level

        while (currentLevel != null) {
            Node dummy = new Node(0); // Dummy node to track the start of the next level
            Node tail = dummy; // Pointer to build the next level connections

            Node node = currentLevel; // Traverse the current level
            while (node != null) {
                if (node.left != null) {
                    tail.next = node.left; // Connect the tail to the left child
                    tail = tail.next; // Move the tail forward
                }
                if (node.right != null) {
                    tail.next = node.right; // Connect the tail to the right child
                    tail = tail.next; // Move the tail forward
                }
                node = node.next; // Move to the next node in the current level
            }

            currentLevel = dummy.next; // Move to the next level (first connected node)
        }
        return root;
    }

}
