class Solution {
    public int maxProfit(int[] prices) {
        // Buy high, sell low
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
