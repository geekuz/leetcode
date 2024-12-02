package leetcode1;

import java.util.Stack;

public class MinOperations {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log: logs) {
            res += add(log,res);
        }
        return res;
    }
    private int add(String log, int res) {
        return log.charAt(1) == '.' ? res == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 : 1;
    }
//    public int minOperations(String[] logs) {
//        Stack<String> stack = new Stack<>();
//        for (String log : logs) {
//            if (log.equals("./")) {
//                continue;
//            } else if (log.equals("../")) {
//                if(stack.empty()){
//                    continue;
//                }else{
//                    stack.pop();
//                }
//            } else stack.push(log);
//        }
//        return stack.size();
//    }
}
