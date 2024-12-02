package leetcode1;

public class ReverseParentheses {
    static int i = 0;

    public static String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public static String helper(char[] s) {
        StringBuilder sb = new StringBuilder();

        while (i < s.length) {
            if (s[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s[i] == '(') {
                i++;
                String st = helper(s);
                //System.out.println(st);
                sb.append(st);
            } else {
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }

/*    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder stringBuilder = new StringBuilder();
                while (stack.peek() != '(') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                for (char c1 : stringBuilder.toString().toCharArray()) {
                    stack.push(c1);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }*/

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
    }
}
