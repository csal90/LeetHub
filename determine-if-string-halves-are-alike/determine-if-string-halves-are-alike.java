class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length() / 2;
        String s1 = s.substring(0, (s.length() / 2));
        String s2 = s.substring((s.length()/2));
        int s1c = 0, s2c = 0;
        
        // Count number of vowels in each string
        for (int i = 0; i < n; i++) {
            
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || 
                s1.charAt(i) == 'i' || s1.charAt(i) == 'o' ||
                s1.charAt(i) == 'u' || s1.charAt(i) == 'A' || 
                s1.charAt(i) == 'E' || s1.charAt(i) == 'I' ||
                s1.charAt(i) == 'O' || s1.charAt(i) == 'U') {
                s1c += 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) == 'a' || s2.charAt(i) == 'e' || 
                s2.charAt(i) == 'i' || s2.charAt(i) == 'o' ||
                s2.charAt(i) == 'u' || s2.charAt(i) == 'A' || 
                s2.charAt(i) == 'E' || s2.charAt(i) == 'I' ||
                s2.charAt(i) == 'O' || s2.charAt(i) == 'U') {
                s2c += 1;
            }
        }
        
        if (s1c == s2c) {
            return true;
        }
        
        return false;
    }
}
