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
        Path filePath= Path.of("C:/Users/MrAkmal/Documents/dev/day03.txt");
        List<String> lines=new ArrayList<>();
        try {
            lines=Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lines);
        String regex="mul\\(\\d+,\\d+\\)";
        String innerRegex="\\d+";
        Pattern pattern=Pattern.compile(regex);
        Pattern innerPattern=Pattern.compile(innerRegex);
        List<String> results=new ArrayList<>();
        for (String line : lines) {
            Matcher matcher= pattern.matcher(line);
            while(matcher.find()) {
                results.add(matcher.group());
            }
        }
        int sum=0;
        for (String result : results) {
            Matcher innerMatcher=innerPattern.matcher(result);
            List<Integer> tempList=new ArrayList<>();
            while (innerMatcher.find()) {
                tempList.add(Integer.parseInt(innerMatcher.group()));
            }
            sum+=Math.multiplyExact(tempList.get(0),tempList.get(1));
        }
        System.out.println(sum);

    }

}
