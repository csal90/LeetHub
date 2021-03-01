class Solution {
    /*
        GREEDILY CHOOSE BASED ON END POINTS
        - Sort the intervals based on end points 
        - Keep track of end time
        - If current start time is less than the previous
          end time, we have an interval. Count!
        
        [[1,2],[1,3],[2,3],[3,4]]
        
        
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) 
            return 0;
        
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        
        int remove = 0;
        int prevEnd = intervals[0][1]; 
        
        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            if (currentStart < prevEnd) { // if current start time is less than previous end time, overlap!
                remove++;
            } else { // if it does not overlap we simply update our end time to current end time
                prevEnd = intervals[i][1]; // no overlap, update new end time
            }
        }
        
        return remove;
        
    }
}