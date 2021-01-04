class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0, j = 0, res = 1, n = s.length();
        
        if (n * k == 0) {
            return 0;
        }
      
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (j < n) {
            if (map.size() <= k) {
                map.put(s.charAt(j), j++);
            }
            if (map.size() == k + 1) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                i = delIndex + 1;
            }
            
            res = Math.max(res, j - i);
        }
        return res;
    }
}
