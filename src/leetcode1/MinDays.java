package leetcode1;

public class MinDays {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n) {
            return -1;
        }

        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private static boolean isValid(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
                if (count == k) {
                    m--;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return m <= 0;
    }
}
