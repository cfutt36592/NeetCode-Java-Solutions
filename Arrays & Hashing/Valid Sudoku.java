class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        for(int i = 0; i < rows; i++){
            rowSet = new HashSet<>();
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '.') continue;
                if(rowSet.contains(board[i][j])) return false;
                rowSet.add(board[i][j]);
            }
        }
        
        for(int j = 0; j < cols; j++){
            colSet = new HashSet<>();
            for(int i = 0; i < rows; i++){
                if(board[i][j] == '.') continue;
                if(colSet.contains(board[i][j])) return false;
                colSet.add(board[i][j]);
            }
        }

        for(int i = 0; i < rows; i += 3){
            for(int j = 0; j < cols; j += 3){
                if(!square(i, j, board)) return false;
            } 
        }
        
        return true;
    }

    public boolean square(int r, int c, char[][] board){
        Set<Character> squareSet = new HashSet<>();
        int rows = r + 3;
        int cols = c + 3;

        for(int i = r; i < rows; i++){
            for(int j = c; j < cols; j++){
                if(board[i][j] == '.') continue;
                if(squareSet.contains(board[i][j])) return false;
                squareSet.add(board[i][j]);
            }
        }
        return true;
    }

}
