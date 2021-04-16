package problems.stringArrays;

public class longestCommonSubsquence {

    // initialize at 1
    public static int longestAgain(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    // initialize at 0
    public static int longest(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }

            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }

    public static void main(String[] args) {
        int longest = longest("LACLAC", "LCLCAC");
        System.out.println("Longest common subsquence initialize 0: " + longest);

        int longest2 = longestAgain("LACLAC", "LCLCAC");
        System.out.println("Longest common subsquence initalize 1: " + longest2);
    }
}
