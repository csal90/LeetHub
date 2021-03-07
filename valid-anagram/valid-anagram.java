class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            count[curr]++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            int curr = t.charAt(i) - 'a';
            count[curr]--;
        }
        
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}