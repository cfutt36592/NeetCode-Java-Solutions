class DetectSquares {
    private int[][] grid;

    public DetectSquares() {
        grid = new int[1001][1001];
    }
    
    public void add(int[] point) {
        grid[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int currentSquareCount = 0;
        int startRow = point[0];
        int startCol = point[1];
        int curRow = point[0];
        int curCol = point[1];

        while (curRow != 0 && curCol != 0) {
            curRow--;
            curCol--;
            if(grid[curRow][curCol] > 0 && grid[startRow][curCol] > 0 && grid[curRow][startCol] > 0){
                currentSquareCount += grid[curRow][curCol] * grid[startRow][curCol] * grid[curRow][startCol];
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 1000 && curCol != 1000) {
            curRow++;
            curCol++;
            if(grid[curRow][curCol] > 0 && grid[startRow][curCol] > 0 && grid[curRow][startCol] > 0){
                currentSquareCount += grid[curRow][curCol] * grid[startRow][curCol] * grid[curRow][startCol];
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 0 && curCol != 1000) {
            curRow--;
            curCol++;
            if(grid[curRow][curCol] > 0 && grid[startRow][curCol] > 0 && grid[curRow][startCol] > 0){
                currentSquareCount += grid[curRow][curCol] * grid[startRow][curCol] * grid[curRow][startCol];
            }
        }

        curRow = point[0];
        curCol = point[1];
        while (curRow != 1000 && curCol != 0) {
            curRow++;
            curCol--;
            if (grid[curRow][curCol] > 0 && grid[startRow][curCol] > 0 && grid[curRow][startCol] > 0){
                currentSquareCount += grid[curRow][curCol] * grid[startRow][curCol] * grid[curRow][startCol];
            }
        }

        return currentSquareCount;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
