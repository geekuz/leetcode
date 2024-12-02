package leetcode1;

public class MergeNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode mergeNodes(ListNode head) {
        // Initialize a sentinel/dummy node with the first non-zero value.
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            // Find the sum of all nodes until you encounter a 0.
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            // Assign the sum to the current node's value.
            modify.val = sum;
            // Move nextSum to the first non-zero value of the next block.
            nextSum = nextSum.next;
            // Move modify also to this node.
            modify.next = nextSum;
            modify = modify.next;
        }
        return head.next;
    }

/*    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode start = new ListNode(0);
        ListNode ans = start;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                ListNode sumNode = new ListNode(sum);
                start.next = sumNode;
                start = sumNode;
                sum = 0;
            }
            head = head.next;
        }
        return ans.next;
    }*/
}
