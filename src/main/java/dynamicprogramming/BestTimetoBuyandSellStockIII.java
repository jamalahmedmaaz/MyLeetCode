package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII bestTimetoBuyandSellStockIII = new BestTimetoBuyandSellStockIII();
        System.out.println(bestTimetoBuyandSellStockIII.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    private int maxProfit(int[] ints) {
        return 0;
    }

    public int maxProfit_incorrect_approach(int[] prices) {

        int[][] mem = new int[prices.length][prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                mem[i][j] = prices[j] - prices[i];
            }
        }

        int usedj = -1;
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {

                if (total < mem[i][j]) {
                    total = Math.max(total, mem[i][j]);
                    usedj = j;
                }
            }
        }

        int totalTmp = 0;
        for (int i = usedj + 1; i < prices.length; i++) {
            for (int j = usedj + 2; j < prices.length; j++) {

                if (totalTmp <= mem[i][j]) {
                    totalTmp = totalTmp + Math.max(totalTmp, mem[i][j]);
                }
            }
        }

        return total + totalTmp;
    }

    class MyDS {
        private int startIndex;
        private Set<Integer> indexs = new HashSet<>();
        private int total;

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public Set<Integer> getIndexs() {
            return indexs;
        }

        public void setIndexs(Set<Integer> indexs) {
            this.indexs = indexs;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "MyDS{" +
                    "startIndex=" + startIndex +
                    ", indexs=" + indexs +
                    ", total=" + total +
                    '}';
        }
    }
}
