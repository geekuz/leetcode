package leetcode1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Step 1: Store projects as (capital, profit) pairs
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        // Step 2: Sort projects by required capital (ascending)
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        // Step 3: Use a max heap to store profits of projects that can be started
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0; // Pointer for sorted projects

        // Step 4: Select up to k projects
        for (int i = 0; i < k; i++) {
            // Add all affordable projects to the max heap
            while (index < n && projects[index][0] <= w) {
                maxHeap.offer(projects[index][1]);
                index++;
            }

            // If no available project, stop early
            if (maxHeap.isEmpty()) break;

            // Pick the most profitable project
            w += maxHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println(ipo.findMaximizedCapital(k, w, profits, capital)); // Output: 4
    }
}
