package problems.stringArrays;

public class longestRepeatingNonOverlappingSubString {

    public static int longest(String str1) {
        int[][] dp = new int[str1.length()][str1.length()];
        int res = 0;
        for (int i = 0; i < str1.length() - 1; i++) {
            for (int j = i + 1; j < str1.length(); j++) {
                if (str1.charAt(i) == str1.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;

                        // j-1 is to not overlap
                    } else if (dp[i - 1][j - 1] < j-i) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }

                    if (res < dp[i][j]) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int banana = longest("banana");
        System.out.println("Longest repeating non overlapping substring: " + banana);
    }
}
