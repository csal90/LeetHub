class Solution {
    int count = 0, sx = 0, sy = 0;
    public int uniquePathsIII(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) { // we found the starting point
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) { // we found an empty square, count it. 
                    count++;
                }
            }
        }
        
        return helper(grid, sx, sy, count);
    }
    
    public int helper(int[][] grid, int x, int y, int count) {
        if (x < 0 || grid.length - 1 < x || y < 0 || grid[0].length - 1 < y || grid[x][y] == -1) {
            return 0;
        }
        
        if (grid[x][y] == 2) { // we found an ending square
            if (count == -1) { // check for valid count
                return 1;
            } else {
                return 0;
            }
        }
        
        int temp = grid[x][y]; // copy a current spots so we do not repeat it
        grid[x][y] = -1; // overwrite current value with zero so that we know we have been there
        count--;
        
        int up = helper(grid, x-1, y, count);
        int down = helper(grid, x+1, y, count);
        int right = helper(grid, x, y-1, count);
        int left = helper(grid, x, y+1, count);
    
        grid[x][y] = temp;
        count++;
        return up + down + right + left;
    }
}
