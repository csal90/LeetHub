class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
    
        int R = rooms.length, C = rooms[0].length;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < k) {
            return;
        }
        rooms[i][j] = k;
        dfs(rooms, i + 1, j, k + 1); 
        dfs(rooms, i - 1, j, k + 1);
        dfs(rooms, i, j + 1, k + 1);
        dfs(rooms, i, j - 1, k + 1);
    }
}
