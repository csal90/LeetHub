class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int LCS = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                // WE HAVE A SEQUENCE 
                int tmpExtend = 1;
                while (set.contains(num + 1)) {
                    tmpExtend += 1;
                    num++;
                }
                LCS = Math.max(LCS, tmpExtend);
            }
        }
        return LCS;
    }
}