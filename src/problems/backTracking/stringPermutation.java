package problems.backTracking;

import java.util.ArrayList;
import java.util.List;

public class stringPermutation {
    public static void main(String[] args) {
        String x = "abc";
        permute(x);
    }

    private static void permute(String x) {
        List<String> result = new ArrayList<>();
        permuation(x, result, 0, x.length()-1);
        System.out.println(result);
    }

    private static void permuation(String x, List<String> result, int start, int end) {
        if (start == end) {
            result.add(x);
        } else {
            for (int i = start; i <= end; i++) {
                x = swap(x, i, start);
                permuation(x, result, start + 1, end);
                x = swap(x, i, start);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
