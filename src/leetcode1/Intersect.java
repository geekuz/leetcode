package leetcode1;

import java.util.*;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int[] result = new int[1001];

        for (int num : nums1) {
            arr[num]++;
        }

        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }

        return Arrays.copyOfRange(result, 0, ctr);


/*        int i = 0, j = 0, k = 0;
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);*/
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
