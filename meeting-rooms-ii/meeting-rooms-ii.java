class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); 

        PriorityQueue<Integer> pq = new PriorityQueue<>
            ((i1, i2) -> Integer.compare(i1, i2));
        
        int[] prev = intervals[0];
        pq.add(prev[1]);
        
        for (int i = 1; i < intervals.length; i++) { 
            int[] curr = intervals[i]; 
            if (curr[0] >= pq.peek()) pq.poll();
            pq.add(curr[1]);
        }
        
        return pq.size();
    }
}