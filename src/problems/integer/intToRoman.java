package problems.integer;

import java.util.*;

public class intToRoman {


    //tree map natural order is keys ascending 1 -> n
    private static String intToRoman(int x) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        StringBuilder s = new StringBuilder();

        for (Map.Entry<Integer, String> e: entries) {

            while (x >= e.getKey()) {
                s.append(e.getValue());
                x = x - e.getKey();
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String roman = intToRoman(15);

        System.out.print("Roman is: " + roman);
    }
}
