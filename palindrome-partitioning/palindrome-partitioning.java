class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<>(), s);
        return res;
    }   
    
    void dfs(int start, List<List<String>> res, List<String> currList, String s) {
        if (start >= s.length()) res.add(new ArrayList<>(currList));
        
        for (int j = start; j < s.length(); j++) {
            if (isPalindrome(s, start, j)) {
                
                // add current substring in the current list
                currList.add(s.substring(start, j + 1));
                dfs(j + 1, res, currList, s);
                
                // backtrack and remove the current substring from curr list
                currList.remove(currList.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j) {
         while (i < j) {
             if (s.charAt(i++) != s.charAt(j--)) {
                 return false;
             }
         }
         return true;
     }
}
