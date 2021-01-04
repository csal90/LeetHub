class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0, j = 0, res = 0, n = s.length(), counter = 0;
        
        if (n < 3) {
            return n;
        }
        
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.get(s.charAt(j)) == 1) {
                counter++;
            }
            j++;
            while (counter > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    counter--;
                }
                i++;
            }
                res = Math.max(res, j - i);
        }
        
        return res;
    }
}
