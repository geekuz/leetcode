package leetcode1;

public class Kadanes_Algorithm {
    public int maxSubarraySum(int[] nums) {
        int maxSum = nums[0], maxSumEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHere = Math.max(nums[i], maxSumEndingHere + nums[i]);
            maxSum = Math.max(maxSum, maxSumEndingHere);
        }

        return maxSum;
    }

    public static void main(String[] args) {

    }
}
