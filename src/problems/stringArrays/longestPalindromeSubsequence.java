package problems.stringArrays;

// do it diagonal
// o(n^2)
public class longestPalindromeSubsequence {

    public static int find(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i <str.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i< str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = 2;
            } else {
                dp[i][+1] = 1;
            }
        }

        for (int k = 3; k <= str.length(); k++) {
            for (int i = 0; i <= str.length() - k; i++) {

                if (str.charAt(i) == str.charAt(k-1+i)) {
                    // b a b = (2)b + (x)1
                    dp[i][k-1+i] = dp[i+1][k-1+i-1] + 2;

                } else {
                    dp[i][k-1+i] = Math.max(dp[i][k-1+i-1], dp[i+1][k-1+1]);
                }
            }
        }

        return dp[0][str.length()-1];
    }

    public static void main(String[] args) {
        int bbbab = find("bbbab");
        System.out.print("bbbab: " + bbbab);
    }

}
