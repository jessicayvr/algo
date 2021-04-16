package problems.integer;

public class stockII {

    public static void main(String[] args) {
        int[] i = new int[]{7, 1, 5, 3, 6, 4};

        System.out.print(findStockProfit(i));
    }

    private static int findStockProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {

            // find next local minimum, if i+1 is smaller keep going
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }

            int min = prices[i];
            i++;

            // find next local maximum, if i+1 is bigger keep going
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }

            // handle if i reaches end just add 0;
            profit = profit + (i < prices.length ? prices[i] - min : 0);
            i++;
        }
        return profit;
    }
}
