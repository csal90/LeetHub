class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Output array and nums in a List 
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        
        // Convert nums array to a List
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        
        int n = nums.length;
        backtrack(n, numsList, res, 0);
        return res;
    }
    
    public void backtrack(int n, 
                          ArrayList<Integer> nums, 
                          List<List<Integer>> res, 
                          int first) {
        // if all integers have been used 
        if (first == n) {
            res.add(new ArrayList<Integer>(nums));
        }
        // start a permutation
        for (int i = first; i < n; i++) {
            // place i-th integer first
            Collections.swap(nums, first, i);
            // use next integers to complete permutation
            backtrack(n, nums, res, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }
​
}
