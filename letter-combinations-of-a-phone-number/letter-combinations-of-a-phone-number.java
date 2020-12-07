class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letter = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) return res;
        
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            res = combine(letter[digits.charAt(i) - '0'], res);
        }
        return res;
    }
    
    public static List<String> combine(String digit, List<String> lst) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < digit.length(); i++) {
            for (String x: lst) {
                res.add(x + digit.charAt(i));
            }
        }
        
        return res;
    }
}
