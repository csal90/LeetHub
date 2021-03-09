class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] counter = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            counter[c2 - 'a']--;
            counter[c - 'a']++;
        }
                
        for (int num : counter) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}