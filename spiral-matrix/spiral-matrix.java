class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int size = matrix.length * matrix[0].length;
​
        if (matrix.length == 0) return res;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (res.size() < size) {
            // traverse top row row left to right and add elements
            for (int i = left; i <= right && res.size() < size; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // traverse top to bottom of right col
            for (int i = top; i <= bottom && res.size() < size; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            // traverse right to left of bottom
            for (int i = right; i >= left && res.size() < size; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            // traverse bottom up of left
            for (int i = bottom; i >= top && res.size() < size; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
