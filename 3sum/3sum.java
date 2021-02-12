class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high]; 
                // if we have answer
                if (temp == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // while we have duplicates update your low pointer
                    while (low < high && nums[low] == nums[low + 1]) 
                        low++;
                    // while we have duplicates update your high pointer 
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    
                    // there are no duplicates so we can simply update them 
                    low++;
                    high--;
                }
                
                else if (temp < 0) {
                    low++;
                } else {
                    high--;
                }
            }   
        }
        return result;
    }
}