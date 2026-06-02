package leetcode1;

public class BasicCalculator {
    //Input: s = "1 + 1"
    //Output: 2

//Input: s = " 2-1 + 2 "
//Output: 3

    //    Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();      // sign before '('
                result += stack.pop();      // result before '('
            }
        }

        return result + sign * num;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }
}
