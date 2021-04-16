package problems.stringArrays;


// O(n^2)
public class longestPalindromeSubstring {

    public static void main(String[] args) {
        longest("cbbc");
    }

    public static String longest(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
            }
        }
        int max = 2;
        String result = "";
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j <= s.length()-i; j++) {
                if (s.charAt(j) == s.charAt(j + i-1) && dp[j+1][j+i-1-1]) {
                    dp[j][j+i-1] = true;
                    if (i > max) {
                        result = s.substring(j, j+i);
                        max = i;
                    }
                }
            }
        }
        return result;
    }
}
