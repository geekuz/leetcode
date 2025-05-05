package leetcode1.yandex;

import java.util.ArrayList;
import java.util.List;

public class PartionLabels {

    public static List<Integer> partitionLabels(String s) {
        // Step 1: Record the last occurrence of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Traverse the string to determine partitions
        List<Integer> result = new ArrayList<>();
        int maxBoundary = 0;  // Tracks the end of the current partition
        int partitionStart = 0;  // Tracks the start of the current partition

        for (int i = 0; i < s.length(); i++) {
            maxBoundary = Math.max(maxBoundary, lastOccurrence[s.charAt(i) - 'a']);

            // If the current index reaches the max boundary, finalize the partition
            if (i == maxBoundary) {
                result.add(i - partitionStart + 1);  // Add the size of the partition
                partitionStart = i + 1;  // Update the start for the next partition
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> ans = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(ans);
    }
}
