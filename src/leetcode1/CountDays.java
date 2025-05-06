package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDays {
    public int countDays(int days, int[][] meetings) {
        // Step 1: Sort meetings based on start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Step 2: Merge overlapping meetings
        List<int[]> mergedMeetings = new ArrayList<>();
        for (int[] meeting : meetings) {
            if (!mergedMeetings.isEmpty() && mergedMeetings.get(mergedMeetings.size() - 1)[1] >= meeting[0]) {
                // Merge overlapping intervals
                mergedMeetings.get(mergedMeetings.size() - 1)[1] =
                        Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
            } else {
                mergedMeetings.add(meeting);
            }
        }

        // Step 3: Count available days
        int count = 0;
        int prevEnd = 0; // Track the last occupied day

        for (int[] meeting : mergedMeetings) {
            // Add available days before the next meeting starts
            count += meeting[0] - prevEnd - 1;
            prevEnd = meeting[1]; // Update the last occupied day
        }

        // Step 4: Count remaining days after last meeting
        if (prevEnd < days) {
            count += days - prevEnd;
        }

        return count;
    }

}
