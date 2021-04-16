package problems.stringArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class printZigZag {

    private static String print(String s, int numRows) {
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new ArrayList<>());
        }


        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (j <= numRows-1 && i < s.length()) {
                map.get(j).add(s.charAt(i));
                j++;
                i++;
            }
            int k = numRows-2;
            while (k > 0 && i < s.length()) {
                map.get(k).add(s.charAt(i));
                k--;
                i++;
            }
        }

        StringBuilder x = new StringBuilder();
        for (int m = 0; m < numRows; m++) {
            List<Character> characters = map.get(m);
            for (Character c :characters) {
                x.append(c);
            }
        }
       return x.toString();
    }

    public static void main(String[] args) {
        String str = print("PAYPALISHIRING", 4);
        System.out.print(str);
    }
}
