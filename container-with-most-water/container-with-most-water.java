class Solution {
    public int maxArea(int[] height) {
        int maxVal = Integer.MIN_VALUE;
        int low = 0, high = height.length - 1;
        
        while (low < high) {
            int min = Math.min(height[low], height[high]);
            maxVal = Math.max(maxVal, min * (high - low));
            
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return maxVal;
    }
}