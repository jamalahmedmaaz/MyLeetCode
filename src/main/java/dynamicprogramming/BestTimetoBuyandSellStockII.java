package dynamicprogramming;

public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new BestTimetoBuyandSellStockII();
        System.out.println(bestTimetoBuyandSellStockII.maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    public int maxProfit(int[] prices) {

        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                total = total + prices[i + 1] - prices[i];
            }
        }
        return total;

    }
}
