class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        
        maxprofit, minstock = float('-inf'), prices[0]
        
        for i in range(len(prices)):
            if prices[i] < minstock:
                minstock = prices[i]
            if prices[i] - minstock > maxprofit:
                maxprofit = prices[i] - minstock
        
        return maxprofit