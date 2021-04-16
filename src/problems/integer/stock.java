package problems.integer;

public class stock {

    /**
     * If you were only permitted to complete at most one transaction
     * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     */
    public static void main(String[] args) {
        int[] x = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(x));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;

        // always points to the min in the array
        int j = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[j]) {
                j = i;
            }
            max = Math.max(max, prices[i]-prices[j]);
        }
        return max;
    }
}
