class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        //top & bottom row
        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[rows - 1][i] == 'O') dfs(board, rows - 1, i);
        }

        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
