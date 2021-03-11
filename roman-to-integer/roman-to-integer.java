class Solution {
    public int romanToInt(String s) {        
        HashMap<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        
        int n = s.length();        
        int counter = map.get(s.charAt(n - 1));
        
        for (int i = n - 2; i >= 0; i--) {
            char c = s.charAt(i);
            int prev = map.get(s.charAt(i + 1));
            if (map.containsKey(c)) {
                int curr = map.get(c);
                if (curr >= prev) {
                    counter += curr;
                } else {
                    counter -= curr;
                }
            }
        }
            
        return counter;
    }
}