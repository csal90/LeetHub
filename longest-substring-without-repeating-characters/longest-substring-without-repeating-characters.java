class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            - Use a hashset
            - Sliding window
            - Two pointer approach Max ( lenSoFar , j - i)
            - We start j at i + 1
            - For each index see if we can grow window 
        */
        int n = s.length();
        int max = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
}