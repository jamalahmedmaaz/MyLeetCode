package dynamicprogramming;

/**
 * Created by jamal on 8/4/18.
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};


        /**
         * Kadane's Algorithm
         *
         * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/
         * Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-:)-(In-case-if-interviewer-twists-the-input)
         * */

        int currentMax = 0;
        int totalMax = 0;

        for (int i = 1; i < prices.length; i++) {
            currentMax = Math.max(0, currentMax + (prices[i] - prices[i - 1]));

            totalMax = Math.max(totalMax, currentMax);
        }

        System.out.println(totalMax);
    }


    /**
     * TIME LIMIT EXCEEDED
     *
     * @param prices
     * @return
     */
    public int mysolution_but_outof_timeLimitExceeded(int[] prices) {
        if (prices.length > 0) {
            int currentMax = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    currentMax = Math.max(prices[j] - prices[i], currentMax);
                }
            }
            return currentMax;
        }
        return 0;
    }

}
