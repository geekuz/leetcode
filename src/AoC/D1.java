package AoC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class D1 {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/MrAkmal/Documents/dev/day01.txt");
        List<String> lines;

        {
            try {
                lines = Files.readAllLines(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println(lines);
        int sum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split("\\s+");
            list1.add(Integer.parseInt(split[0]));
            list2.add(Integer.parseInt(split[1]));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(sum);
        /*------------------------------------Day1 Part2------------------*/
        int similarityScore = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list1) {
            long count = list2.stream()
                    .filter(number -> number.equals(i))
                    .count();
            map.put(i, (int) count);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int num= integerIntegerEntry.getKey() * integerIntegerEntry.getValue();
            if(num!=0){
                similarityScore+=num;
            }
        }
        System.out.println(similarityScore);
    }

}
