class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        
        int max = 1;
        int left = 0; 
        
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) 
                set.remove(s.charAt(left++));
            set.add(c);
            max = Math.max(i + 1 - left, max);
        }
        return max;
        
    }
}
