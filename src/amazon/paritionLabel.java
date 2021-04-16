package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class paritionLabel {
    // can also use greedy to solve, only care about last char index.
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> result = doparition(str);
        System.out.println(result);
    }

    private static List<Integer> doparition(String str) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < str.length() ; i++ ) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int[] indexes = map.get(c);
                indexes[1] = i;
                map.put(c, indexes);
            } else {
                map.put(c, new int[] {i,i});
            }
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int[] index = map.get(c);
            int last = index[1];
            int first = index[0];
            if (i == max) {
                result.add(max-min+1);
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            } else if (last> max) {
                max = last;
                if (first < min) {
                    min = first;
                }
            }
        }

        return result;
    }
}
