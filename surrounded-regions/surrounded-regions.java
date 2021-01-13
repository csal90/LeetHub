class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int row = board.length, col = board[0].length;
        
        // condition to check first and last row 
        for(int i=0; i<board[0].length ;i++){
        if(board[0][i]=='O')
            dfs(board, 0, i);
        if(board[board.length-1][i]=='O')
            dfs(board, board.length-1, i);
        
    }
    
    // this for loop handles all boundary condition in 1st & last col.
     for(int i=0; i<board.length ;i++){
        if(board[i][0]=='O')
            dfs(board, i, 0);
        if(board[i][board[0].length-1]=='O')
            dfs(board, i, board[0].length-1);
        
    }
        
        /// DFS the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
