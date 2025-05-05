package AoC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D3 {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/MrAkmal/Documents/dev/day03.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String nextRegex = "mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)";
        String innerRegex = "\\d+";

        Pattern nextPattern = Pattern.compile(nextRegex);
        Pattern innerPattern = Pattern.compile(innerRegex);

        List<String> validInstructions = new ArrayList<>();
        int sum = 0;
        boolean flag = true;

        for (String line : lines) {
            Matcher nextMatcher = nextPattern.matcher(line);

            while (nextMatcher.find()) {
                String match = nextMatcher.group();
                validInstructions.add(match);

                if (match.equals("do()")) {
                    flag = true;
                } else if (match.equals("don't()")) {
                    flag = false;
                } else if (match.startsWith("mul(") && flag) {
                    Matcher innerMatcher = innerPattern.matcher(match);
                    List<Integer> tempList = new ArrayList<>();
                    while (innerMatcher.find()) {
                        tempList.add(Integer.parseInt(innerMatcher.group()));
                    }
                    if (tempList.size() == 2) {
                        sum += Math.multiplyExact(tempList.get(0), tempList.get(1));
                    }
                }
            }
        }

        for (String instruction : validInstructions) {
            System.out.println(instruction);
        }

        System.out.println(sum);
    }
}