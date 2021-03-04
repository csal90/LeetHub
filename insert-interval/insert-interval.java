class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        
        
        for (int[] curr : intervals) {
            if (curr[1] < newInterval[0]) {
                res.add(curr);
            }
            else if (curr[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = curr;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
    
        res.add(newInterval);
        
        return res.toArray(new int[res.size()][]);
    }
}