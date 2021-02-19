class Solution {
    public int maxProfit(int[] prices) {
        /*
            7,1,5,3,6,4
            
            buy low -> keep track of a min value 
            sell high -> at each position that is > than the min
                         check if prices[i] - min > than the max.
                         if it is, set the max to {prices[i] - min}
        */
        
        int min = Integer.MAX_VALUE, maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }
}