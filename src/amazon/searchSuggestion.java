package amazon;

import java.util.*;

public class searchSuggestion {

    public static void main(String[] args) {
        String[] products1 = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String str1 = "mouse";

        String[] products2 = {"havana"};
        String str2 = "havana";

        String[] products3 = {"bags","baggage","banner","box","cloths"};
        String str3 = "bags";

        String[] products4 = {"havana"};
        String str4 = "tatiana";

        List<List<String>> result = searchWord(str1, products1);
        System.out.println(result);
    }

    private static List<List<String>> searchWord(String searchWord, String[] products) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            List<String> subStringResult = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(substring) && subStringResult.size() < 3) {
                    subStringResult.add(product);
                }
            }
            result.add(subStringResult);

        }

        return result;
    }
}
