package leetcode1;

import java.util.*;

public class kthDistinct {
    public static String kthDistinct(String[] arr, int k) {
        int totalDistinctVal = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for(String s:arr) {
            if(!nonDistinctSet.contains(s)) {
                if(!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinctVal++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinctVal--;
                }
            }
        }
        if(totalDistinctVal<k) {
            return "";
        }
        for(String s:arr) {
            if(distinctSet.contains(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
//    public static String kthDistinct(String[] arr, int k) {
//        Map<String, Integer> map = new LinkedHashMap<>();
//        for (String s : arr) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                arrayList.add(entry.getKey());
//            }
//        }
//        if (k > arrayList.size()) {
//            return new String();
//        } else {
//            return arrayList.get(k-1);
//        }
//    }

    public static void main(String[] args) {
        String[] str = new String[]{"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(kthDistinct(str, k));
    }
}
