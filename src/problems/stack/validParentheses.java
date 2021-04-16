package problems.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParentheses {

    public static void main(String[] args) {
        String s = "]()[]{}";
        boolean valid = isValid(s);
        System.out.print(valid);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != map.get(c)) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
