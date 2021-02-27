class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int M = matrix.length; 
        if (M == 0) return result;
        int N = matrix[0].length > 0 ? matrix[0].length : 0;

        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];
        
        // left and right 
        for (int row = 0; row < M; row++) {
            dfs(matrix, row, 0, matrix[row][0], pacific);
            dfs(matrix, row, N - 1, matrix[row][N - 1], atlantic);
        }
        
        // top and bottom
        for (int col = 0; col < N; col++) {
            dfs(matrix, 0, col, matrix[0][col], pacific);
            dfs(matrix, M - 1, col, matrix[M - 1][col], atlantic);
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] matrix, int r, int c, int preHeight, boolean[][] ocean) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || 
            matrix[r][c] < preHeight || ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        dfs(matrix, r + 1, c, matrix[r][c], ocean);
        dfs(matrix, r - 1, c, matrix[r][c], ocean);
        dfs(matrix, r, c + 1, matrix[r][c], ocean);
        dfs(matrix, r, c - 1, matrix[r][c], ocean);
    }
}