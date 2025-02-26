package leetcode1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
// Hash maps for character frequencies
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;
        int formed = 0, required = targetCount.size();
// Expand the window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
// Check if the current character satisfies the frequency in t
            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }
// Contract the window
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar).intValue() < targetCount.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
