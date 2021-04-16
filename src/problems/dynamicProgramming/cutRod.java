package problems.dynamicProgramming;

// O(n^2)
public class cutRod {
    // what is the highest val you can get
    public static int cutRod(int[] val) {
        int[] dp = new int[val.length + 1];
        for (int i = 1; i <= val.length; i++) {
            dp[i] = val[i - 1];
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], val[j] + dp[i - j - 1]);
            }
        }
        return dp[val.length];
    }

    public static void main(String[] args) {
        int[] val = {1, 5, 8, 9, 10, 17, 17, 20};
        int j = cutRod(val);
        System.out.println(j);
    }

}
