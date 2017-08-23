public class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, m, n, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int m, int n, int i, int j, int ind, String word){
        if(ind == word.length()){
            return true;
        }
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(ind) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(helper(board, m, n, i+1, j, ind+1, word) ||
           helper(board, m, n, i-1, j, ind+1, word) ||
           helper(board, m, n, i, j+1, ind+1, word) ||
           helper(board, m, n, i, j-1, ind+1, word)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}

