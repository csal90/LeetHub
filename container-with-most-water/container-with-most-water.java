class Solution {
    public int maxArea(int[] height) {
        
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = 0; j < height.length; j++) {
        //         max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        //     }
        // }
        // return max;
        
        int maxArea = 0;
        int low = 0, high = height.length - 1;
        
        while (low < high) {
            int minBar = Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, minBar * (high - low));  
            
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return maxArea;
        
    }
}