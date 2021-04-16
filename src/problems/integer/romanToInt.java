package problems.integer;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

    private static Integer romantToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int i = 0;
        int res = 0;
        while (i < s.length()) {
            int j = i + 1;
            if (j < s.length() && map.containsKey(s.substring(i, j + 1))) {
                res = res + map.get(s.substring(i, j + 1));
                i = j + 1;
            } else {
                res = res + map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String roman = "IV";

        int d = romantToInt(roman);
        System.out.println("MINE: " + d);

    }
}
