class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) return true;
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
           board[i][j] == '#' || word.charAt(k) != board[i][j]) return false;
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        if (dfs(board, i + 1, j, word, k + 1) ||
            dfs(board, i - 1, j, word, k + 1) ||
            dfs(board, i, j + 1, word, k + 1) ||
            dfs(board, i, j - 1, word, k + 1)) return true;
        
        board[i][j] = temp;
        return false;
    }
}
