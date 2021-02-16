class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        
        while (low <= high):
            pivot = (high + low) // 2
            # check lucky case
            if nums[pivot] == target:
                return pivot
            
            # check if it exisits in the LHS
            elif nums[pivot] >= nums[low]:
                if target >= nums[low] and target < nums[pivot]:    
                    high = pivot - 1
                else:
                    low = pivot + 1
            
            else:# check if it exisits in the RHS
                if target >= nums[pivot] and target <= nums[high]:
                    low = pivot + 1
                else:
                    high = pivot - 1
                
        return -1