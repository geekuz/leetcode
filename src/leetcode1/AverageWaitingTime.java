package leetcode1;

import java.util.Arrays;

public class AverageWaitingTime {
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double time_waiting = customers[0][1]; // Initial waiting time for the first customer
        int finished_prev = customers[0][0] + customers[0][1]; // When the chef finishes the first order

        for (int customer_ind = 1; customer_ind < n; ++customer_ind) {
            int[] times = customers[customer_ind];
            int arrive = times[0];
            int cook_time = times[1];

            // The chef starts cooking at the max of arrival time or when the previous order finishes
            int start_cook = Math.max(arrive, finished_prev);
            int end_time = start_cook + cook_time;
            finished_prev = end_time; // Update the finish time of the current order
            time_waiting += end_time - arrive; // Add the waiting time for the current customer
        }

        return time_waiting / n; // Return the average waiting time
    }


    public static void main(String[] args) {
        int[][] customers = new int[][]{{1, 2}, {2, 5}, {4, 3}};
        averageWaitingTime(customers);
    }

}
