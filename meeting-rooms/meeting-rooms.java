class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return true;
​
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            } 
        }
        return true;
    }
}
