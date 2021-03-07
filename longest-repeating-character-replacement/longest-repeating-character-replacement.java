class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] freq = new int[26];
        
        int i = 0, j = 0, maxRepeating = 0, overallMax = 0;
        
        while(i < N && j < N)  {
            freq[s.charAt(j) - 'A']++;
            int curr = freq[s.charAt(j) - 'A'];
            maxRepeating = Math.max(maxRepeating, curr);
            while (j - i - maxRepeating + 1 > k) { 
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            overallMax = Math.max(overallMax, j - i + 1);
            j++;
        }
        
        return overallMax;
    }
}