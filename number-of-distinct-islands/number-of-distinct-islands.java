class Solution {    
        public int numDistinctIslands(int[][] grid) {
            HashSet<String> pathSet = new HashSet<>();
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j< grid[0].length; j++) {
                    if(grid[i][j]==1) {
                        StringBuilder sb = new StringBuilder();
                        dfs(i, j, grid, sb, 'o');
                        pathSet.add(sb.toString());
                    }
                }
            }
            return pathSet.size();
        }

        private void dfs(int r, int c, int[][] grid, StringBuilder sb, char dir) {
            int nr = grid.length, nc = grid[0].length;
            if(r<0 || r>=nr || c<0 || c>=nc || grid[r][c]==0) return;
            sb.append(dir);
            grid[r][c]=0;

            dfs(r+1, c, grid, sb, 'r');
            dfs(r-1, c, grid, sb, 'l');
            dfs(r, c-1, grid, sb, 'u');
            dfs(r, c+1, grid, sb, 'd');

            sb.append("b");
        }
}