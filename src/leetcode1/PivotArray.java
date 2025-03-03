package leetcode1;

import java.util.Arrays;

public class PivotArray {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        // Count elements less than, equal to, and greater than pivot
        int smallerCount = 0, equalCount = 0;
        for (int num : nums) {
            if (num < pivot) smallerCount++;
            else if (num == pivot) equalCount++;
        }

        // Fill result array using three pointers
        int smallIndex = 0;
        int equalIndex = smallerCount;
        int bigIndex = smallerCount + equalCount;

        for (int num : nums) {
            if (num < pivot) result[smallIndex++] = num;
            else if (num == pivot) result[equalIndex++] = num;
            else result[bigIndex++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {9, 12, 5, 10, 14, 3, 10};
        int[] ans = pivotArray(ints, 10);
        System.out.println(Arrays.toString(ans));
    }
}
