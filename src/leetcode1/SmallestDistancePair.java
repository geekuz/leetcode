package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallestDistancePair {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;

            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 1};
        int i = smallestDistancePair(ints, 3);
        System.out.println(i);
    }
}
