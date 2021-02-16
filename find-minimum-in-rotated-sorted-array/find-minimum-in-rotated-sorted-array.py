class Solution:
    def findMin(self, nums: List[int]) -> int:
        # check if array is already sorted
        if len(nums) == 1:
            return nums[0]
        
        if nums[0] < nums[len(nums) - 1]:
            return nums[0]
        
        low = 0
        high = len(nums) - 1
        
        while low < high:
            pivot = (high + low) // 2
            
            # [1,2,3,7,8]
            
            # LHS is increasing && RHS is decreasing
            if nums[pivot] > nums[pivot + 1]:
                return nums[pivot + 1]
                
            # RHS is increasing && LHS is decreasing
            if nums[pivot] < nums[pivot - 1]:
                return nums[pivot]
        
            # move pointers
            if nums[low] > nums[pivot]:
                high = pivot - 1
            else:
                low = pivot + 1
        
        return -1