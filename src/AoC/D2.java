package AoC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class D2 {

    public static void main(String[] args) {
        int ans = 0;
        Path filePath = Path.of("/home/creativeuz/Documents/AoC/day02.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (String line : lines) {
            List<Integer> miniList = new ArrayList<>();
            String[] split = line.split("\\s+");
            for (String s : split) {
                miniList.add(Integer.parseInt(s));
            }
            list.add(miniList);
        }
        for (List<Integer> integers : list) {
            boolean safe = isSafe(integers);
            if (!safe) {
                safe = canBeSafeWithOneRemoval(integers); // Check with Problem Dampener
            }
            if (safe) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isSafe(List<Integer> integers) {
        boolean isIncreasing = true;
        boolean safe = true;
        for (int i = 1; i < integers.size(); i++) {
            int dif = Math.abs(integers.get(i) - integers.get(i - 1));
            if (i == 1 && integers.get(i) - integers.get(0) < 0) {
                isIncreasing = false;
            }
            if (integers.get(i) - integers.get(i - 1) < 0) {
                if (isIncreasing) {
                    safe = false;
                }
            } else {
                if (!isIncreasing) {
                    safe = false;
                }
            }

            if (dif < 1 || dif > 3) {
                safe = false;
                continue;
            }
        }
        return safe;
    }

    private static boolean canBeSafeWithOneRemoval(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            // Create a copy of the list without the i-th element
            List<Integer> modifiedList = new ArrayList<>(integers);
            modifiedList.remove(i);

            // Check if the modified list is safe
            if (isSafe(modifiedList)) {
                return true; // If any modification makes it safe, return true
            }
        }
        return false; // If no modification makes it safe, return false
    }
}