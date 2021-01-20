class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (String word : words) {
                    if (board[i][j] == word.charAt(0) && dfs(board, word, new boolean[m][n], i, j, 0)) {
                        result.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int counter) {
        if (word.length() == counter) return true;
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || visited[i][j] || board[i][j] != word.charAt(counter)) {
            return false;
        } 
        
        visited[i][j] = true;;
        
        if (dfs(board, word, visited, i + 1, j, counter + 1) ||
            dfs(board, word, visited, i - 1, j, counter + 1) || 
            dfs(board, word, visited, i, j + 1, counter + 1) ||
            dfs(board, word, visited, i, j - 1, counter + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}
