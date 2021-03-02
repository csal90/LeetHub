class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[1], x[0]))
        
        count = 0
        latest = -1e100
        for start, end in intervals:
            # [[1, 2], [1,3], [2,3], [3,4]]
            if start < latest:
                count += 1
            else:
                latest = max(latest, end)
        
        return count