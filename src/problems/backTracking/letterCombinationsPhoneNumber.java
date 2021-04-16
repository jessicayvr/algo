package problems.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationsPhoneNumber {

    public static void main(String[] args) {
        String phone = "233";

        doCombination(phone);
    }

    private static void doCombination(String phone) {
        List<String> result = new ArrayList<>();
        Map<Integer, String> digits = new HashMap<>();
        digits.put(0, "");
        digits.put(1, "");
        digits.put(2, "abc");
        digits.put(3, "def");
        digits.put(4, "ghi");
        digits.put(5, "jkl");
        digits.put(6, "mno");
        digits.put(7, "pqrs");
        digits.put(8, "tuv");
        digits.put(9, "wxyz");
        doBT(phone, result, "", 0, digits);
        System.out.println(result);

    }
    // start is which digit in the phone number youre on
    private static void doBT(String phone, List<String> result, String s, int start, Map<Integer, String> map) {
        if (s.length() == phone.length()) {
            result.add(s);
            return;
        }

        char c = phone.charAt(start);
        int numericValue = Character.getNumericValue(c);
        String s1 = map.get(numericValue);

        for (int i = 0; i < s1.length(); i++) {
            doBT(phone, result, s + s1.charAt(i), start + 1, map);
        }

    }
}
