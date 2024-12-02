package leetcode1;

public class SortArray {
    static int[] arr;

    public static int[] sortArray(int[] nums) {
        arr = nums;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    reverse(arr, i, j);
                }
            }
        }
        return arr;
    }

    public static void reverse(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
