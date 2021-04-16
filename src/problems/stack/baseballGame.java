package problems.stack;

import java.util.Stack;

public class baseballGame {

    public static void main(String[] args) {
        String[] input = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int i = calPoints(input);
        System.out.print(i);
    }

    public static int calPoints(String[] input) {
        Stack<Integer> stack = new Stack<>();
        Integer result;
        for (int i = 0; i < input.length; i++) {
            String str = input[i];
            if (str == "C") {
                stack.pop();
            } else if (str == "D") {
                result = 2 * stack.peek();
                stack.push(result);
            } else if (str.equals("+")) {
                Integer last = stack.pop();
                Integer secondlast = stack.peek();
                result = last + secondlast;
                stack.push(last);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int max = 0;
        while (!stack.isEmpty()) {
            max = max + stack.pop();
        }
        return max;
    }
}
