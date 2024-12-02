package leetcode1;

import java.util.Arrays;

public class MinDifference {
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        Arrays.sort(nums);

        // Possible moves:
        // 1. Change the three largest elements
        // 2. Change the two largest elements and the smallest element
        // 3. Change the largest element and the two smallest elements
        // 4. Change the three smallest elements

        int minDifference = Integer.MAX_VALUE;

        // Compare the difference between the smallest remaining and largest remaining values
        minDifference = Math.min(minDifference, nums[n - 4] - nums[0]); // Change the three largest
        minDifference = Math.min(minDifference, nums[n - 3] - nums[1]); // Change the two largest and the smallest
        minDifference = Math.min(minDifference, nums[n - 2] - nums[2]); // Change the largest and the two smallest
        minDifference = Math.min(minDifference, nums[n - 1] - nums[3]); // Change the three smallest

        return minDifference;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 6, 0, 1, 1, 4, 6};
        System.out.println(minDifference(arr));
    }
}
