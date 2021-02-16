class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxsofar = nums[0]
        maxendinghere = nums[0]
        
        for i in range(1, len(nums)):
            maxendinghere = max(nums[i], nums[i] + maxendinghere)
            maxsofar = max(maxsofar, maxendinghere)
            
        return maxsofar
        