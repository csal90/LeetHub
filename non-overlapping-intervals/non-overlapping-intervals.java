class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        int count = 0;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // sort by start time 
        
        int[] prev = intervals[0]; // first interval 
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < prev[1]) { // overlap
                count += 1;
                prev[1] = Math.min(prev[1], curr[1]);
            } else {
                prev = curr;
            }
        }
        
        return count;
    }
}