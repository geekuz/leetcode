package leetcode1;

public class SortColors {

    //    public static void sortColors1(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[i]>nums[j]){
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//    }

    public static void sortColors(int[] nums) {
        int t = 0, k = nums.length - 1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0 && i != t) {
                int temp = nums[t];
                nums[t] = nums[i];
                nums[i] = temp;
                t++;
            } else if (k > i && nums[i] == 2) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
