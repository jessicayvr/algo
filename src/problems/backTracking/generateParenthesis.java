package problems.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        List<String> strings = computeParenthesis(3);
        System.out.println(strings);
    }

    private static List<String> computeParenthesis(int i) {
        List<String> result = new ArrayList<>();
        computeParenthesis(i, result, "", 0, 0);
        return result;
    }

    private static void computeParenthesis(int n, List<String> result, String currentString, Integer open, Integer close) {

        if (currentString.length() == n * 2) {
            result.add(currentString);
            return;
        }

        if (open < n) {
            computeParenthesis(n, result, currentString + "(", open + 1, close);
        }

        if (close < open) {
            computeParenthesis(n, result, currentString + ")", open, close + 1);
        }
    }


}
