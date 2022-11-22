class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    max = Math.max(max, findArea(grid, r, c));
                }
            }
        }
        
        return max;
    }

    public int findArea(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + (
            findArea(grid, r + 1, c) +
            findArea(grid, r - 1, c) +
            findArea(grid, r, c + 1) +
            findArea(grid, r, c - 1)
        );
    }
}
