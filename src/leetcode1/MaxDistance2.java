package leetcode1;

import java.util.List;

public class MaxDistance2 {
    public static int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            // Calculate the potential max distances using the global min and max
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - globalMin));
            maxDistance = Math.max(maxDistance, Math.abs(globalMax - currentMin));

            // Update globalMin and globalMax for next iteration
            globalMin = Math.min(globalMin, currentMin);
            globalMax = Math.max(globalMax, currentMax);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(1, 2, 3)
        );

        System.out.println(maxDistance(arrays));
    }
}
