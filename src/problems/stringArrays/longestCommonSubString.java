package problems.stringArrays;

public class longestCommonSubString {

    public static int longest(String str1, String str2) {
        int res = 0;
        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i ==0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
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
        int longest = longest("LACLAC", "LCLCAC");
        System.out.println("The longest substring length is: "+ longest);
    }
}
