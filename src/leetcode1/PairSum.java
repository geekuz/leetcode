package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class PairSum {
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

    public int pairSum(ListNode head) {
        if (head == null || head.next == null) return 0;

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Calculate the twin sums
        ListNode firstHalf = head;
        int maxSum = 0;
        while (secondHalf != null) {
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: Optionally restore the list (if needed)
        // reverseList(slow);

        return maxSum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

/*    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.max(list.get(i) + list.get(j), ans);
            i++;
            j--;
        }
        return ans;
    }*/
}
