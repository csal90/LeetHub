class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashTable = dict()
        for i in range(len(nums)):
            delta = target - nums[i]
            if delta in hashTable:
                return (i, hashTable[delta])
            else:
                hashTable[nums[i]] = i
        return None
        