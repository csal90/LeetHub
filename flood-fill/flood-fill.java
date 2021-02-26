class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // check here (think base case)
        if (image[sr][sc] == newColor) return image;
        int currentColor = image[sr][sc];
        dfs(image, sr, sc, newColor, currentColor);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor, int currentColor) {
        // Boundry check 
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length
           || image[row][col] != currentColor) {
            return;
        } 
        // "MARK"
        image[row][col] = newColor;
        
        // DFS (UP, DOWN, LEFT, RIGHT)
        dfs(image, row + 1, col, newColor, currentColor);
        dfs(image, row - 1, col, newColor, currentColor);
        dfs(image, row, col + 1, newColor, currentColor);
        dfs(image, row, col - 1, newColor, currentColor);
    }
}