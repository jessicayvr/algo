package problems.integer;

import java.util.Stack;

public class basicCalculator {

    public static void main(String[] args) {
        System.out.println(doCal("3+2*2"));
    }

    private static int doCal(String s) {
        String str = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = '+';
        for (int i = 0 ; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num = (num * 10) + str.charAt(i) - '0';
            }
            if (!Character.isDigit(str.charAt(i)) || i == str.length()-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    Integer pop = stack.pop();
                    stack.push(pop * num);
                } else if (sign == '/') {
                    Integer pop = stack.pop();
                    stack.push(pop/num);
                }
                sign = str.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res = res + stack.pop();
        }
        return res;
    }
}
